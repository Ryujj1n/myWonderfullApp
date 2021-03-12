package fr.ecoloscan.studentSimulator.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserInscription", value = "/UserInscription")
public class UserInscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String VUE = "index.jsp";
    private static final String PSEUDO =  "pseudo";
    private static final String PASSWORD =  "password";
    private static final String PASSWORDCONFIRM =  "passwordConfirm";
    private static final String CONDITION =  "checkCondition";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_RESULTAT = "resultat";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> erreurs = new HashMap<String, String>();
        String result;
        String pseudo  = request.getParameter(PSEUDO);
        String password = request.getParameter(PASSWORD);
        String passwordConfirmation = request.getParameter(PASSWORDCONFIRM);
        Boolean isChecked = Boolean.parseBoolean( request.getParameter(CONDITION));


        try {
            pseudoValidation(pseudo);
        } catch (Exception e) {
            erreurs.put(PSEUDO, e.getMessage());
        }
        try {
            passwordValidation(password, passwordConfirmation);
        } catch (Exception e) {
            erreurs.put(PASSWORD, e.getMessage());
        }
        try {
            conditionValidation(isChecked);
        } catch (Exception e) {
            erreurs.put(CONDITION, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            result = "Succès de l'inscription.";
        } else {
            result ="Échec de l'inscription.";
        }

        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, result);

        this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
    }

    private void pseudoValidation(String pseudo) throws Exception {
        if (pseudo.isEmpty() || pseudo == null) {
            throw new Exception("Veuillez saisir un pseudo");
        }
    }
    private void passwordValidation(String password, String passwordConfirmation) throws Exception {
        if (password != null && password.trim().length() != 0 && password != null && password.trim().length() != 0) {
            if (!password.equals(passwordConfirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (password.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }
    private void conditionValidation(Boolean condition) throws Exception {
        if (condition == null || condition.equals(false)) {
            throw new Exception("Veuillez cocher la case.");
        }
    }


}
