package com.aweiz.wiki.controller;

import com.aweiz.wiki.service.WikiService;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiInfo;
import com.sun.tools.internal.jxc.ap.Const;
import org.springframework.beans.factory.annotation.Autowired;
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
}
