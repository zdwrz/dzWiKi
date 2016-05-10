package com.aweiz.wiki.service;

import com.aweiz.wiki.utility.WikiOperationType;
import org.junit.Test;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by daweizhuang on 5/5/16.
 */
public class CommonTest {
    @Test
    public void test1(){
//        Map<String, Date> tokens = new ConcurrentHashMap<>();
//        tokens.containsKey(null);
        System.out.println(WikiOperationType.CREATE.getValue());
    }
}
