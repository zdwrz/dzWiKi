package com.aweiz.wiki.domain;

import java.util.Date;

/**
 * Created by daweizhuang on 4/27/16.
 */
public class Wiki {
    private String id;
    private String title;
    private String content;
    private String priority;
    private String category;
    private String[] label;
    private Date touchedDate;

    public Date getTouchedDate() {
        return touchedDate;
    }

    public void setTouchedDate(Date touchedDate) {
        this.touchedDate = touchedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
