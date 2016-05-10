package com.aweiz.wiki.dao;

import com.aweiz.wiki.domain.EmailTemplate;

/**
 * Created by daweizhuang on 5/10/16.
 */
public interface EmailDAO {
    EmailTemplate getEmailTemplateByName(String name);
}
