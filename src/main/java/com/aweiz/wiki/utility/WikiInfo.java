package com.aweiz.wiki.utility;

import com.aweiz.wiki.domain.Wiki;

import java.util.Date;
import java.util.Random;

/**
 * Created by daweizhuang on 4/27/16.
 */
public class WikiInfo {
    private Wiki wiki;

    public WikiInfo() {
        wiki = new Wiki();
    }
    public WikiInfo(String id, String title, String content) {
        wiki = new Wiki();
        wiki.setId(id);
        wiki.setTitle(title);
        wiki.setContent(content);
    }

    public WikiInfo(Wiki wiki) {
        this.wiki = wiki;
    }

    public Wiki getWiki() {
        return wiki;
    }

    public void setWiki(Wiki wiki) {
        this.wiki = wiki;
    }

    public String getTitle() {
        return wiki.getTitle();
    }

    public void setTitle(String title) {
        wiki.setTitle(title);
    }

    public String getContent() {
        return wiki.getContent();
    }

    public void setContent(String content) {
        wiki.setContent(content);
    }

    public String getPriority() {
        return wiki.getPriority();
    }

    public void setPriority(String priority) {
        wiki.setPriority(priority);
    }

    public String getCategory() {
        return wiki.getCategory();
    }

    public void setCategory(String category) {
        wiki.setCategory(category);
    }

    public String[] getLabel() {
        return wiki.getLabel();
    }

    public void setLabel(String label) {
        if(label != null) {
            String[] res = label.split(" ");
            wiki.setLabel(res);
        }
    }

    public String getWikiTitle(){
        return this.getTitle();
    }
    public String getWikiContent(){
        return this.getContent();
    }
    public String getWikiContentBrief(){
        String brief = null;
        if(this.getContent().length() > 400){
            brief = this.getContent().substring(0,400);
        }else{
            brief = this.getContent();
        }
        return brief;
    }

    public String getId() {
        return wiki.getId();
    }

    public void setId(String id) {
        wiki.setId(id);
    }

    public Date getTouchedDate(){ return wiki.getTouchedDate();}

    public void setTouchedDate(Date date) {
        wiki.setTouchedDate(date);
    }

}
