package com.aweiz.wiki.utility;

/**
 * Created by daweizhuang on 5/10/16.
 */
public enum WikiOperationType {
    CREATE("Created"), UPDATE("Updated"), LOAD("Loaded"), REMOVE("Removed");
    String type;
    WikiOperationType(String value) {
        this.type = value;
    }
    public String getValue(){return type;}
}
