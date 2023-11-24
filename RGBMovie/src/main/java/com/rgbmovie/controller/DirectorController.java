package com.rgbmovie.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rgbmovie.dto.CastDTO;
import com.rgbmovie.dto.DirectingDTO;
import com.rgbmovie.dto.DirectorDTO;
import com.rgbmovie.dto.MovieDTO;
import com.rgbmovie.helpers.AppConstant;
import com.rgbmovie.model.DirectingModel;
import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.service.DirectorService;
import com.rgbmovie.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/director")
public class DirectorController {
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", AppConstant.cloudinaryName,
            "api_key", AppConstant.apiKey,
            "api_secret", AppConstant.apiSecret,
            "secure", AppConstant.secure));
    @Autowired
    private DirectorService directorService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        request.getSession().setAttribute("directorList", null);
        if (model.asMap().get("success") != null)
            redirect.addFlashAttribute("success", model.asMap().get("success").toString());
        return "redirect:/admin/director/page/1";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("directorList");
        int pageSize = 10;
        List<DirectorModel> list = directorService.getAllFilmDrirect();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pageSize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("directorList", pages);
        int current = pages.getPage() + 1;
        int begin = Math.max(1, current - list.size());
        int end = Math.min(begin + 9, pages.getPageCount());
        int totalPageCount = pages.getPageCount();
        if (current >= end) {
            current = pages.getPage() + 1;
            begin = Math.max(current - end + 1, current - list.size());
            end = Math.min(current, pages.getPageCount());
            // totalPageCount = pages.getPageCount();
        }
        String baseUrl = "/admin/director/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("directors", pages);
        model.addAttribute("movies", movieService.getAllNotHaveDirector().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("movie", movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("director", new DirectorDTO());
        return "director/index";
    }

    @PostMapping("/add")
    public String addNew(@RequestParam("img") MultipartFile img, DirectorDTO directorDTO, @RequestParam("movie") List<Integer> directingDTOs, Model model) throws IOException {
        directorDTO.setProfileImg(cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap()).get("url").toString());
        try {
            directorService.addNew(modelMapper.map(directorDTO, DirectorModel.class), directingDTOs);
            model.addAttribute("message", "Add new director success");
        } catch (DataAccessException e) {
            return e.toString();
        }
        return "redirect:/admin/director";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("director", directorService.getById(id));
        model.addAttribute("movies", movieService.getAllNotHaveDirector().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("movie", movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        return "director/profile";
    }

    @PutMapping("edit")
    public String edit(DirectorModel directorModel, @RequestHeader String referer, @RequestParam("image") MultipartFile image, RedirectAttributes model) throws IOException {
        String name = StringUtils.cleanPath(image.getOriginalFilename());
        if (!name.isEmpty()) {
            var imageUpload = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap()).get("url").toString();
            directorModel.setProfileImg(name);
        }
        try {
            directorService.edit(directorModel);
            model.addFlashAttribute("message", "Edit success");
            return "redirect:" + referer;
        } catch (Exception e) {
            model.addFlashAttribute("message", e.toString());
            return "redirect:" + referer;
        }

    }

    @GetMapping("/delete/movie")
    public String deleteMovie(@RequestParam("id") int id, @RequestHeader String referer, RedirectAttributes model) {
        try {
            directorService.deleteMovie(id);
            model.addAttribute("message", "Success");
        } catch (Exception e) {
            model.addFlashAttribute("message", e.toString());
        }
        return "redirect:" + referer;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, @RequestHeader String referer, RedirectAttributes model) {

        try {
            model.addFlashAttribute("message", directorService.delete(id));
            return "redirect:" + referer;
        } catch (Exception e) {
            model.addFlashAttribute("message", e.toString());
            return "redirect:" + referer;
        }
    }

    @PutMapping("/addMovie")
    public String addNewMovie(@RequestHeader String referer, @RequestParam("movie") List<Integer> directingDTOs, @RequestParam("directorId") int id, RedirectAttributes model) {
        try {
            directorService.addNewMovie(id, directingDTOs);
            model.addFlashAttribute("message", "Success");
        } catch (DataAccessException e) {
            model.addFlashAttribute("message", "Something wrong");
        }
        return "redirect:" + referer;
    }
}
