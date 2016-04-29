package com.aweiz.wiki.utility;

import com.aweiz.wiki.domain.Wiki;

import java.util.Random;

/**
 * Created by daweizhuang on 4/27/16.
 */
public class WikiInfo {
    private String title;
    private String content;
    private String priority;
    private String category;
    private String label;
    private String id;

    public WikiInfo() {

    }
    public WikiInfo(String s) {
        id = s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDummyWikiTitle(){
        return " Here is the random title";
    }
    public String getDummyWikiContent(){
        return " Here is the random Content, skdjfskdjf kssf sdf " +
                "sd fsdf sdf sdf sdf sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk js" +
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj"+
                "sd fsdfsdfsdfdfk jskdfj ksjdfkj sdkfj skdljf laksdjf ksjdf lajsdf jasldfj asljdf kjsadflk jsdkjf slkd fjsalkdjf slkdjf laksdjf klasjdf kajsdlfk jaslkdj falksd fj";
    }
    public String getDummyWikiContentBrief(){
        return " Here is the random Content, sd fj";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WikiInfo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
