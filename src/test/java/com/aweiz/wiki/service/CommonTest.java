package com.aweiz.wiki.service;

import com.aweiz.wiki.utility.WikiOperationType;
import org.junit.Test;

/**
 * Created by daweizhuang on 5/5/16.
 */
public class CommonTest {
    @Test
    public void test1(){
        System.out.println(WikiOperationType.CREATE.getValue());
    }
}
