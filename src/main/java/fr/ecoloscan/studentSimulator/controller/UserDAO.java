package fr.ecoloscan.studentSimulator.controller;

import fr.ecoloscan.studentSimulator.model.entity.User;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public List<User> getUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    public boolean addUser(User user) {
        try {
            userTransaction.begin();
            entityManager.persist(user);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "> JPA error : " + e.getMessage());
            return false;
        }
    }

    public boolean deleteUser(Long id) {
        try {
            userTransaction.begin();
            User user = (User) entityManager.createQuery("select user from User user where user.id = ?1").setParameter(1, id).getSingleResult();
            entityManager.remove(user);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "> JPA error : " + e.getMessage());
            return false;
        }
    }

    public boolean updateUser(User user) {
        try {
            userTransaction.begin();
            entityManager.merge(user);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "> JPA error : " + e.getMessage());
            return false;
        }
    }

    public Long getUserScore(String username) {
        return entityManager.createQuery("select user from User user where user.username = ?1", User.class).setParameter(1, username).getSingleResult().getScore();
    }

    public boolean addUserScore(Long score, String username) {
        try {
            User user = getUsers().stream().filter(user1 -> user1.getUsername().equals(username)).findFirst().get();
            Long actualScore = user.getScore();
            user.setScore(actualScore+score);
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "> JPA error : " + e.getMessage());
            return false;
        }
    }
}