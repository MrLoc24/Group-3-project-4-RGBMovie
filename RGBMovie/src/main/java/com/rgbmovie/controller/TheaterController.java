package com.rgbmovie.controller;

import java.util.List;

import com.rgbmovie.dto.*;
import com.rgbmovie.model.AuditoriumModel;
import com.rgbmovie.model.MovieModel;
import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.model.TheaterModel;
import com.rgbmovie.service.*;
import jakarta.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheaterController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private WorkplaceService workplaceService;
    @Autowired
    private MovieService movieService;


    @RequestMapping(value = {"/theater"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request, RedirectAttributes redirect) {
        request.getSession().setAttribute("theaterList", null);
        if (model.asMap().get("success") != null)
            redirect.addFlashAttribute("success", model.asMap().get("success").toString());
        return "redirect:/theater/page/1";
    }

    @RequestMapping(value = "/theater/page/{pageNumber}", method = RequestMethod.GET)
    public String showUserPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
        PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("theaterList");
        int pageSize = 10;
        List<TheaterDTO> list = theaterService.getAll().stream().map(m -> modelMapper.map(m, TheaterDTO.class)).toList();
        if (pages == null) {
            pages = new PagedListHolder<>(list);
            pages.setPageSize(pageSize);
        } else {
            final int goToPage = pageNumber - 1;
            if (goToPage <= pages.getPageCount() && goToPage >= 0) {
                pages.setPage(goToPage);
            }
        }
        request.getSession().setAttribute("theaterList", pages);
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
        String baseUrl = "/theater/page/";
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("baseUrl", baseUrl);
        model.addAttribute("theaters", pages);
        model.addAttribute("theater", new TheaterModel());
        return "theater/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/theater/{id}")
    public String detail(@PathVariable("id") int id, @RequestParam(value = "detail", required = false, defaultValue = "") String detail, @RequestParam(value = "auditorium", required = false, defaultValue = "") String audi, Model model) {
        model.addAttribute("theater", modelMapper.map(theaterService.getById(id), TheaterDTO.class));
        model.addAttribute("theaterId", id);
        model.addAttribute("auditorium", auditoriumService.getByTheater(id).stream().map(m -> modelMapper.map(m, AuditoriumDTO.class)).toList());
        model.addAttribute("screenings", screeningService.getAllByTheater(id).stream().map(m -> modelMapper.map(m, ScreeningDTO.class)).toList());
        model.addAttribute("users", workplaceService.getAllByTheaterId(id).stream().map(m -> modelMapper.map(m, WorkplaceDTO.class)).toList());
        model.addAttribute("movies", movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList());
        if (detail.isEmpty()) {
            return "theater/detail";
        } else {
            if (detail.equals("auditorium")) {
                //For modal add
                model.addAttribute("audi", new AuditoriumDTO());
                //Redirect to auditorium detail
                if (!audi.isEmpty() && Integer.parseInt(audi) != 0) {
                    model.addAttribute("auditor", modelMapper.map(auditoriumService.getById(Integer.parseInt(audi)), AuditoriumDTO.class));
                    model.addAttribute("seats", seatService.findByAuditorium(Integer.parseInt(audi)).stream().map(m -> modelMapper.map(m, SeatDTO.class)).toList());
                    return "seat/index";
                }
                return "auditorium/index";
            }
            //Screening of theater
            if (detail.equals("screening")) {
                model.addAttribute("screening", new ScreeningDTO());
                return "screening/index";
            }
            if (detail.equals("workplace")) {

                return "redirect:/users?workplace=" + id;
            }
        }//Redirect to theater's auditorium
        return "theater/index";

    }

    //Add new auditorium for each theater
    @PostMapping("/theater/{id}")
    public String addAuditorium(@PathVariable("id") int id, @RequestParam(value = "detail", required = false, defaultValue = "") String detail, @RequestParam(value = "add", required = false, defaultValue = "true") String add, AuditoriumDTO auditoriumDTO, ScreeningDTO screeningDTO) {
        if (detail.equals("screening")) {
            screeningDTO.setTheater(id);
            screeningService.addNewScreening(modelMapper.map(screeningDTO, ScreeningModel.class));
            return "redirect:/theater/" + id + "?detail=screening";
        }
        auditoriumDTO.setName(auditoriumDTO.getName() + "_" + id);
        auditoriumDTO.setTheater(id);
        AuditoriumModel result = auditoriumService.addNew(modelMapper.map(auditoriumDTO, AuditoriumModel.class));
        seatService.addNewSeat(result);
        return "redirect:/theater/" + id + "?detail=auditorium";
    }

    @PostMapping("/theater/add")
    public String addNewTheater(Model model, TheaterDTO theaterDTO) {
        TheaterModel result = theaterService.addNew(modelMapper.map(theaterDTO, TheaterModel.class));
        if (result != null) {
            model.addAttribute("message", "Add Success");
            return "redirect:/theater";
        }
        model.addAttribute("message", "Failed to add new");
        return "redirect:/theater";
    }
}
