package com.rgbmovie.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rgbmovie.dto.CastDTO;
import com.rgbmovie.dto.MovieDTO;
import com.rgbmovie.helpers.AppConstant;
import com.rgbmovie.model.MovieModel;
import com.rgbmovie.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/movie")
public class MovieController {
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", AppConstant.cloudinaryName,
            "api_key", AppConstant.apiKey,
            "api_secret", AppConstant.apiSecret,
            "secure", AppConstant.secure));
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MovieService movieService;
    //    @Autowired
//    private UserService userService;
//    @Autowired
//    private AuditoriumService auditoriumService;
//    @Autowired
//    private SeatService seatService;
//    @Autowired
//    private ScreeningService screeningService;
    @Autowired
    private CastService castService;
    @Autowired
    private DirectorService directorService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        request.getSession().setAttribute("movieList", null);
        if (model.asMap().get("success") != null)
            redirect.addFlashAttribute("success", model.asMap().get("success").toString());
        return "redirect:/movie/page/1";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("movieList");
        int pageSize = 10;
        List<MovieDTO> list = movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pageSize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("movieList", pages);
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
        String baseUrl = "/movie/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("movies", pages);
        model.addAttribute("movie", new MovieDTO());
        model.addAttribute("cast", new CastDTO());
        return "movie/index";
    }

    @PostMapping("/add")
    public String addMovie(Model model, @ModelAttribute MovieDTO movieDTO, @RequestParam("main_Img") MultipartFile mainImg, @RequestParam("thumbnail_Img") MultipartFile thumbnailImg) throws IOException {
        var mainResult = cloudinary.uploader().upload(mainImg.getBytes(), ObjectUtils.emptyMap());
        var thumbnailResult = cloudinary.uploader().upload(thumbnailImg.getBytes(), ObjectUtils.emptyMap());
        movieDTO.setThumbnailImg(thumbnailResult.get("url").toString());
        movieDTO.setMainImg(mainResult.get("url").toString());
        movieService.addNew(modelMapper.map(movieDTO, MovieModel.class));
        return "redirect:/movie";
    }
}
