package com.aweiz.wiki.utility;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by daweizhuang on 5/4/16.
 */

public class TokenRepository {
    private static Logger LOGGER = Logger.getLogger(TokenRepository.class);
    private static final TokenRepository instance = new TokenRepository();
    private TokenRepository() {
    }
    public static TokenRepository getInstance() {
        return instance;
    }

    private Map<String, Date> tokens = new ConcurrentHashMap<>();

    public String generateToken() {
        String uuid = UUID.randomUUID().toString();
        LOGGER.info("new token generated = " + uuid);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        tokens.put(uuid,calendar.getTime());
        //need reload
        if(tokens.size() > 50){
            Date today = new Date();
            for (String key : tokens.keySet()) {
                if(tokens.get(key).before(today)){
                    tokens.remove(key);
                }
            }
        }
        return uuid;
    }

    public boolean validateToken(String token) {
        boolean res = false;
        if(StringUtils.isNotEmpty(token) && tokens.containsKey(token) && tokens.get(token).after(new Date())){
            res = true;
        }
        return res;
    }
}
