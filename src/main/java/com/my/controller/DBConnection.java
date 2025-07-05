package com.my.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/connection")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        try (Connection conn = dataSource.getConnection()) {
            response.getWriter().append("<h1>DB Connection Successful</h1>");
        } catch (SQLException e) {
            response.getWriter().append("<h1>Error Connecting to DB:</h1> " + e.getMessage());
        }
    }
}
