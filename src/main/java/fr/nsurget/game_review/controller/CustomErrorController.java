package fr.nsurget.game_review.controller;

import fr.nsurget.game_review.mapping.UrlRoute;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(UrlRoute.URL_ERROR)
@AllArgsConstructor
public class CustomErrorController implements ErrorController {

    @RequestMapping
    public ModelAndView handleError(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("utils/error");
        modelAndView.addObject("code", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        modelAndView.addObject("content",request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        return modelAndView;
    }

}
