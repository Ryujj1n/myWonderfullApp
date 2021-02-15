package fr.ecoloscan.studentSimulator.servlet;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("pseudo-co");
        String password = request.getParameter("password-co");

        if (username.equals(StringUtils.EMPTY) || password.equals(StringUtils.EMPTY)) {
            RequestDispatcher req = request.getRequestDispatcher("index.jsp");
            req.include(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher("game.xhtml");
            req.forward(request, response);
        }
    }
}
