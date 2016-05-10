package com.aweiz.wiki.service;

import com.aweiz.wiki.dao.EmailDAO;
import com.aweiz.wiki.domain.EmailTemplate;
import com.aweiz.wiki.domain.Wiki;
import com.aweiz.wiki.utility.Constants;
import com.aweiz.wiki.utility.WikiOperationType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by daweizhuang on 5/10/16.
 */
@Service
public class EmailServiceImpl implements EmailService {
    private static Logger LOGGER = Logger.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private EmailDAO emailDAO;

    @Autowired
    private WikiServiceImpl wikiService;

    @Override
    public boolean sendWikiOperationNotification(WikiOperationType operation, String id){
        try {
            EmailTemplate template = emailDAO.getEmailTemplateByName(Constants.WIKI_NOTIFICATION_NAME);
            template.setSubject(template.getSubject().replace(":Operation",operation.getValue()));
            template.setMessage(template.getMessage().replace(":Operation",operation.getValue()));
            Wiki wiki = wikiService.loadWikiById(id);
            template.setMessage(template.getMessage().replace(":title",wiki.getTitle()));
            sendEmail(template);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e);
        }
        return true;
    }

    private void sendEmail(EmailTemplate msg) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        String htmlMsg = msg.getMessage();
        mimeMessage.setContent(htmlMsg, "text/html");
        helper.setTo(msg.getTo());
        helper.setSubject(msg.getSubject());
        helper.setFrom(msg.getFrom());
        emailSender.send(mimeMessage);
    }
}
