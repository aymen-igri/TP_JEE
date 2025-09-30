package com.example.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "e3Servlet", value = "/Exo3")
public class e3Servlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter print = resp.getWriter();

            print.println("<html><body>");
            print.println("<strong>requestURL:</strong> " + req.getRequestURL() + "<br>");
            print.println("<strong>requestURI:</strong> " + req.getRequestURI() + "<br>");
            print.println("<strong>contextPath:</strong> " + req.getContextPath() + "<br>");
            print.println("<strong>servletPath:</strong> " + req.getServletPath() + "<br>");
            print.println("<strong>queryString:</strong> " + req.getQueryString() + "<br>");
            print.println("<strong>getParameter text1:</strong> " + req.getParameter("text1") + "<br>");
            print.println("<strong>getParameter text2:</strong> " + req.getParameter("text2") + "<br>");

            print.println("<br><strong>Server info:</strong><br>");
            print.println("<strong>serverName:</strong> " + req.getServerName() + "<br>");
            print.println("<strong>serverPort:</strong> " + req.getServerPort() + "<br>");

            print.println("<br><strong>Client info:</strong><br>");
            print.println("<strong>remoteAddr:</strong> " + req.getRemoteAddr() + "<br>");
            print.println("<strong>remoteHost:</strong> " + req.getRemoteHost() + "<br>");
            print.println("<strong>remotePort:</strong> " + req.getRemotePort() + "<br>");
            print.println("<strong>remoteUser:</strong> " + req.getRemoteUser() + "<br>");

            print.println("<br><strong>headers:</strong><br>");
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                print.println("<strong>" + headerName + ":</strong> " + req.getHeader(headerName) + "<br>");
            }

            print.println("<br><strong>Servlet Context info:</strong><br>");
            print.println("<strong>realPath:</strong> " + getServletContext().getRealPath("/") + "<br>");

            print.println("</body></html>");
        }catch (Exception e){
            System.err.println("Error: "+e);
        }
    }

}
