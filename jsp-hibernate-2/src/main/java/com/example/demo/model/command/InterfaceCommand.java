package com.example.demo.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface InterfaceCommand {

    String execute(HttpServletRequest request, HttpServletResponse response);

}
