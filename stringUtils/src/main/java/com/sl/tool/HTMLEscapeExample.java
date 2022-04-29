package com.sl.tool;



public class HTMLEscapeExample {

    public static void main(String[] args)
    {
        String unEscapedString = "<java>public static void main(String[] args) { ... }</java>";

        String escapedHTML = StringUtils.encodeHtml(unEscapedString);

        System.out.println(escapedHTML);  //Browser can now parse this and print
    }
}
