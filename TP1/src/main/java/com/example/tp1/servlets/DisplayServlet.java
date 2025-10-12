package com.example.tp1.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DisplayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        String text1 = request.getParameter("text1");
        String text2 = request.getParameter("text2");

        String serverName = request.getServerName();
        int serverPort = request.getServerPort();

        String remoteAddr = request.getRemoteAddr();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();

        String realPath = request.getServletContext().getRealPath("/");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><style>");
        out.println(".blue { color: blue; }");
        out.println("</style></head><body>");

        out.println("<span class='blue'>requestURL</span>: " + requestURL + "<br>");
        out.println("<span class='blue'>requestURI</span>: " + requestURI + "<br>");
        out.println("<span class='blue'>contextPath</span>: " + contextPath + "<br>");
        out.println("<span class='blue'>servletPath</span>: " + servletPath + "<br>");
        out.println("<span class='blue'>queryString</span>: " + queryString + "<br>");
        out.println("<span class='blue'>getParameter text1</span>: " + text1 + "<br>");
        out.println("<span class='blue'>getParameter text2</span>: " + text2 + "<br>");
        out.println("<br>");

        out.println("<b>Server info:</b><br>");
        out.println("<span class='blue'>serverName</span>: " + serverName + "<br>");
        out.println("<span class='blue'>serverPort</span>: " + serverPort + "<br>");
        out.println("<br>");

        out.println("<b>Client info:</b><br>");
        out.println("<span class='blue'>remoteAddr</span>: " + remoteAddr + "<br>");
        out.println("<span class='blue'>remoteHost</span>: " + remoteHost + "<br>");
        out.println("<span class='blue'>remotePort</span>: " + remotePort + "<br>");
        out.println("<span class='blue'>remoteUser</span>: " + remoteUser + "<br>");
        out.println("<br>");

        out.println("<b>headers:</b><br>");
        String[] headersToShow = {"host", "connection", "accept", "user-agent", "accept-encoding", "accept-language", "alexatoolbar-alx_ns_ph"};
        for (String headerName : headersToShow) {
            String headerValue = request.getHeader(headerName);
            if (headerValue != null) {
                out.println("<span class='blue'>" + headerName + "</span>: " + headerValue + "<br>");
            }
        }
        out.println("<br>");

        out.println("<b>Servlet Context info:</b><br>");
        out.println("<span class='blue'>realPath</span>: " + realPath + "<br>");

        out.println("</body></html>");
        out.close();
    }
}
