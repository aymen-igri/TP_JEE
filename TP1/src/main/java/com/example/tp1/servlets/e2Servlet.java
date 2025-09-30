package com.example.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet(name = "e2Servlet", value = "/Exo2")
public class e2Servlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException {

        try {
            resp.setContentType("text/html");
            PrintWriter print = resp.getWriter();

            print.println("<html><body>");
            print.println("nom d'utilisateur : " + req.getParameter("username"));
            print.println("mot de passe : " + req.getParameter("password"));
            print.println("nom: "+ req.getParameter("firstName"));
            print.println("prenom: "+ req.getParameter("lastName"));
            print.println("genre: "+ req.getParameter("gender"));
            print.println("addresse: "+ req.getParameter("address"));
        }catch (Exception e){

        }
    }
}
