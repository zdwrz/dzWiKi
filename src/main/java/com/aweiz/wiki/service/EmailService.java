package com.aweiz.wiki.service;

import com.aweiz.wiki.utility.WikiOperationType;

import javax.mail.MessagingException;

/**
 * Created by daweizhuang on 5/10/16.
 */
public interface EmailService {

    boolean sendWikiOperationNotification(WikiOperationType operation, String id);

}
