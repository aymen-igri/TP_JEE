package com.example.tp1.servlets;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "e1Servlet", value = "/Exo1")
public class e1Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nom = req.getParameter("nom");
            String age = req.getParameter("age");

            PrintWriter print = resp.getWriter();

            print.write("<html><body>");
            print.write("<p> <strong> je m’appelle " + nom + "  et j’ai " + age + " ans</strong> </p>");
            print.write("</body></html>");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
