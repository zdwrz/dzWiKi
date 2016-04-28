package com.aweiz.wiki.dao;

/**
 * Created by daweizhuang on 4/27/16.
 */
public interface WikiDAO {
    void saveWiki(String title, String content, String category);
}
