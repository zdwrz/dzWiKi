package com.aweiz.wiki.controller;

import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.TokenRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by daweizhuang on 4/26/16.
 */
@Controller
public class NaviController {
    private static Logger LOGGER = Logger.getLogger(NaviController.class);
    @Autowired
    private WikiService wikiService;

    @RequestMapping("/wiki/{path}")
    public String navigateTo(@PathVariable String path, Model model){
        if(Constants.JAVA.equalsIgnoreCase(path)){
            //load Java data
            model.addAttribute("wikiList", wikiService.loadWikiInfo(Constants.JAVA, 0,Constants.ORDER_TOUCHED_DATE));
        }
        return path;
    }

    @RequestMapping("/validateAccessCode")
    public String validateAccessCode(@RequestParam("access_code") String code, Model model){
        model.addAttribute("token", TokenRepository.getInstance().generateToken());
        model.addAttribute("wikiList", wikiService.loadWikiInfo(Constants.JAVA, 0,Constants.ORDER_TOUCHED_DATE));
        return "redirect:/wiki/java";
    }

    @RequestMapping("/wiki/login")
    public @ResponseBody String login(@RequestParam("user") String userName, @RequestParam("password") String password, @RequestParam("token") String token, Model model){
        LOGGER.info("Got this from client: token : " + token);
        if (password.equals(userName + "123")) {
            return "success";
        }
        return "fail";
    }
}
