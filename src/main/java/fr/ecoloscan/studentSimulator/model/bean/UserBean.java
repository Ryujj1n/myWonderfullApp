package fr.ecoloscan.studentSimulator.model.bean;

import fr.ecoloscan.studentSimulator.controller.UserDAO;
import fr.ecoloscan.studentSimulator.model.entity.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserBean implements Serializable {
    private static  final  long serialVersionUID = 1l;

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

    public Long getUserScore(String username) {
        return userDAO.getUserScore(username);
    }

}
