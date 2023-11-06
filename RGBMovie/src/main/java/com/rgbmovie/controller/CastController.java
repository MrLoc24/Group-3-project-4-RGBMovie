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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cast")
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
        return "redirect:/cast/page/1";
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.GET)
    public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("directorList");
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
        String baseUrl = "/cast/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("casts", pages);
        model.addAttribute("movies", movieService.getAllNotHaveDirector().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        model.addAttribute("cast", new CastDTO());
        return "cast/index";
    }


}