package fr.ecoloscan.studentSimulator.model.bean;

import fr.ecoloscan.studentSimulator.controller.UserDAO;

import javax.inject.Inject;

public class GameBean {
    @Inject
    private UserDAO userDAO;

    public boolean addUserScore(Long score, String username) {
        return userDAO.addUserScore(score, username);
    }
}
