package com.rgbmovie.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rgbmovie.dto.CastDTO;
import com.rgbmovie.dto.DirectorDTO;
import com.rgbmovie.dto.MovieDTO;
import com.rgbmovie.helpers.AppConstant;
import com.rgbmovie.model.CastModel;
import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.service.CastService;
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
import java.util.List;

@Controller
@RequestMapping("/admin/cast")
public class CastController {
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", AppConstant.cloudinaryName,
            "api_key", AppConstant.apiKey,
            "api_secret", AppConstant.apiSecret,
            "secure", AppConstant.secure));
    @Autowired
    private CastService castService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieService movieService;


    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        request.getSession().setAttribute("castList", null);
        if (model.asMap().get("success") != null)
            redirect.addFlashAttribute("success", model.asMap().get("success").toString());
        return "redirect:/admin/cast/page/1";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("castList");
        int pageSize = 10;
        List<CastModel> list = castService.getAllFilmCast();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pageSize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("castList", pages);
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
        String baseUrl = "/admin/cast/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("casts", pages);
        model.addAttribute("movies", movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("cast", new CastDTO());
        return "cast/index";
    }

    @PostMapping("/add")
    public String addNewCast(@RequestParam("img") MultipartFile img, CastDTO castDTO, @RequestParam("movie") List<Integer> movie, Model model) throws IOException {
        castDTO.setProfileImg(cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap()).get("url").toString());
        try {
            model.addAttribute("message", castService.addNew(modelMapper.map(castDTO, CastModel.class), movie));
            return "redirect:/admin/cast";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("cast", castService.getById(id));
        model.addAttribute("movies", movieService.getAllNotCast().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("movie", movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        return "cast/profile";
    }

    @PutMapping("edit")
    public String edit(CastModel castModel, @RequestHeader String referer, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String name = StringUtils.cleanPath(image.getOriginalFilename());
        if (!name.isEmpty()) {
            var imageUpload = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap()).get("url").toString();
            castModel.setProfileImg(name);
        }
        try {
            model.addAttribute("message", castService.edit(castModel));
            return "redirect:" + referer;
        } catch (DataAccessException e) {
            model.addAttribute("message", e.toString());
            return "redirect:" + referer;
        }

    }

    @GetMapping("/delete/movie")
    public String deleteMovie(@RequestParam("id") int id, @RequestHeader String referer, Model model) {
        String result = castService.deleteMovie(id);
        model.addAttribute("message", result);
        return "redirect:" + referer;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, @RequestHeader String referer, Model model) {
        String result = castService.delete(id);
        model.addAttribute("message", result);
        return "redirect:/admin/cast";
    }

}
