package fr.ecoloscan.studentSimulator.model;

import fr.ecoloscan.studentSimulator.controller.UserDAO;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBean {
    @Inject
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public boolean deleteMember(Long id) {
        return userDAO.deleteUser(id);
    }

    public boolean updateMember(User user) {
        return userDAO.updateUser(user);
    }

}
