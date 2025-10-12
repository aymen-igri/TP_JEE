package com.example.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name =req.getParameter("name");
        String age = req.getParameter("age");
        if(name==null){
            name="Nothing";
        }
        if(age==null){
            age="Nothing";
        }
        resp.setContentType("text/HTML");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Je m'appelle " + name +", j'ai "+age+ "</h1>");
    }
}
