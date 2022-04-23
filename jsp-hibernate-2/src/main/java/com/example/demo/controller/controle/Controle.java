package com.example.demo.controller.controle;

import com.example.demo.helper.Helper;
import com.example.demo.model.command.InterfaceCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controle")
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        Helper helper = new Helper(request);
        InterfaceCommand command = helper.getCommand();
        String pagina = command.execute(request, response);
        request.getRequestDispatcher(pagina).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


}
