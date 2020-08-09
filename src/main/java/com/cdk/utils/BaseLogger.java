package com.cdk.utils;

public class BaseLogger {

    public static void log(String message, String... args){
        System.out.println(String.format(message, args));
    }

}
