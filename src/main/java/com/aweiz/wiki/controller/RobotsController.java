package com.aweiz.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by daweizhuang on 9/15/16.
 */
@Controller
public class RobotsController {

    @RequestMapping(value = "/robots.txt", method = RequestMethod.GET)
    public @ResponseBody  String getRobots(HttpServletRequest request) {
        return (Arrays.asList("mysite.com", "www.mysite.com").contains(request.getServerName())) ?
                "robotsAllowed" : "robotsDisallowed";
    }
}