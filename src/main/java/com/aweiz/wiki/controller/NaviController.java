package com.aweiz.wiki.controller;

import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daweizhuang on 4/26/16.
 */
@Controller
public class NaviController {

    @RequestMapping("/wiki/{path}")
    public String navigateTo(@PathVariable String path, Model model){
        if(Constants.JAVA.equalsIgnoreCase(path)){
            //load Java data
            List<WikiInfo> wikiList = new ArrayList<>();
            wikiList.add(new WikiInfo());
            model.addAttribute("wikiList", wikiList);
        }
        return path;
    }
}
