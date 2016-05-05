package com.aweiz.wiki.controller;

import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.TokenRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by daweizhuang on 4/26/16.
 */
@Controller
public class NaviController {
    private static Logger LOGGER = Logger.getLogger(NaviController.class);
    @Autowired
    private WikiService wikiService;

    @RequestMapping("/")
    public String home( Model model, HttpServletRequest request){
        String path = "index";
        String ua = request.getHeader("User-Agent");
        if(StringUtils.isNotEmpty(ua) && (ua.toLowerCase().contains("android") || ua.toLowerCase().contains("iphone"))){
            path = "mobile/" + path;

        }
        return path;
    }

    @RequestMapping("/wiki/{path}")
    public String navigateTo(@PathVariable String path, Model model, HttpServletRequest request){
        if(Constants.JAVA.equalsIgnoreCase(path)){
            //load Java data
            model.addAttribute("wikiList", wikiService.loadWikiInfo(Constants.JAVA, 0,Constants.ORDER_TOUCHED_DATE));
        }
        String ua = request.getHeader("User-Agent");
        if(StringUtils.isNotEmpty(ua) && (ua.toLowerCase().contains("android") || ua.toLowerCase().contains("iphone"))){
            path = "mobile/" + path;

        }
        return path;
    }

    @RequestMapping("/validateAccessCode")
    public String validateAccessCode(@RequestParam("access_code") String code, Model model){
        String res = "redirect:/wiki/java";
        if(!"0216".equals(code)){
            model.addAttribute("error",true);
            res = "redirect:/";
            LOGGER.warn("Invalid access code :" + code);
        }else {
            model.addAttribute("token", TokenRepository.getInstance().generateToken());
            model.addAttribute("wikiList", wikiService.loadWikiInfo(Constants.JAVA, 0, Constants.ORDER_TOUCHED_DATE));
        }
        return res;
    }

    @RequestMapping("/wiki/login")
    public @ResponseBody String login(@RequestParam("user") String userName, @RequestParam("password") String password, Model model){
        LOGGER.info("Got this from client: userName : " + userName + " , password: " + password);
        if (password.equals(userName + "123")) {
            return "success";
        }
        return "fail";
    }
}
