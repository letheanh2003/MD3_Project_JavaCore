package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.User;
import rikkei.academy.service.IUserService;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    List<User> listUsers= new Config<User>().readFromFile(Config.PATH_USER);

    @Override
    public List<User> findAll() {
        return listUsers;
    }

    @Override
    public void save(User user) {
        if (findById(user.getId())== null){
            // add user
            listUsers.add(user);
        }else {
            //update
            for (int i = 0; i < listUsers.size(); i++) {
                if (listUsers.get(i).getId()== user.getId()){
                    listUsers.set(i,user);
                }
            }
        }
        new Config<User>().writeToFile(Config.PATH_USER,listUsers);
    }

    @Override
    public User findById(int id) {
        for (User user : listUsers) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (User user : listUsers) {
            if (user.getId()==id){
                listUsers.remove(user);
                new Config<User>().writeToFile(Config.PATH_USER,listUsers);
                break;
            }
        }
    }

    @Override
    public User login(String username, String password) {
        for (User user : listUsers) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean changeUserStatus(int id) {
        if (findById(id) == null){
            return false;
        }else {
            for (User user : listUsers) {
                if (user.getId()==id){
                    user.setStatus(!user.isStatus());
                    new Config<User>().writeToFile(Config.PATH_USER,listUsers);
                    break;
                }
            }
            return true;
        }
    }

    @Override
    public boolean checkUsernameExists(String username) {
        for (User user : listUsers) {
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
