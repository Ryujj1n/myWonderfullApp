package fr.ecoloscan.studentSimulator.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserInscription", value = "/UserInscription")
public class UserInscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo  = request.getParameter("pseudo");
        String password = request.getParameter("password");
        String passwordC = request.getParameter("passwordConfirm");
        Boolean isChecked = Boolean.parseBoolean( request.getParameter("checkCondition"));
    }
}
