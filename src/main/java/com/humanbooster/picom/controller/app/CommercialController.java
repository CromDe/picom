package com.humanbooster.picom.controller.app;

import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.service.model.CommercialServiceImpl;
import com.humanbooster.picom.service.model.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommercialController {

    private final UserServiceImpl userService;
    private final CommercialServiceImpl commercialService;

    public CommercialController(UserServiceImpl userService, CommercialServiceImpl commercialService) {
        this.userService = userService;
        this.commercialService = commercialService;
    }

    @GetMapping("/app/annonces")
    public ModelAndView getCommercialsDashBoard(Pageable pageable) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("/app/annonces");
        mav.addObject("user", userService.getUserByMail(auth.getName()));
        Client client = userService.getClientByMail(auth.getName());
        mav.addObject("campagnes", commercialService.getCommercialsByClient(client,pageable));
        return mav;
    }

}
