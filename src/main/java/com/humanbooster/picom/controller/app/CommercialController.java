package com.humanbooster.picom.controller.app;

import com.humanbooster.picom.service.model.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommercialController {

    private final UserServiceImpl userService;

    public CommercialController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/app/annonces")
    public ModelAndView getCommercialsDashBoard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("/app/annonces");
        mav.addObject("user", userService.getUserByMail(auth.getName()));
        return mav;
    }

}
