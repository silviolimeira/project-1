package com.example.demo.util;

import com.sl.tool.StringUtils;

public class StringUtilsTest {


    public static void main(String[] args) {

        String escapedHTML = StringUtils.encodeHtml("Acentuação");

        System.out.println(escapedHTML);
    }
}
