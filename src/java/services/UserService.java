/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

/**
 *
 * @author parve
 */
public class UserService {
  //  public User get(String email) throws Exception {
       // UserDB userDB = new UserDB();
//        User user = userDB.get(email);
        //return userDB;
//    }
    
    public List<User> getAll(String email) throws Exception {
        UserDB noteDB = new UserDB();
        List<User> users= noteDB.getAll(email);
        return users;
    }
    
    public void insert(String fname, String lname, String password) throws Exception {
        User user = new User(fname, lname, password);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String fname, String lname, String password) throws Exception {
        User user = new User(fname, lname, password);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
