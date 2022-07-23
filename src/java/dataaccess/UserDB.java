/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author parve
 */
public class UserDB {

    public List<User> getAll(String email) throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
      //  Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE email=?";
        
        try {
         //   ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                 email= rs.getString(1);
                boolean active=rs.getBoolean(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String password = rs.getString(5);
                User user = new User(email, active, fname, lname);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
           // cp.freeConnection(con);
        }

        return users;
    }

    public User get(int noteId) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        //Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE email=?";
        
        try {
       //     ps = con.prepareStatement(sql);
            String email = null;
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                boolean active = rs.getBoolean(2);
                String fname = rs.getString(3);
                String lname = rs.getString(4);
                String password=rs.getString(5);
                user = new User(email, active, fname, lname,password);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
      //      cp.freeConnection(con);
        }
        
        return user;
    }

    public void insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
       // Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user(active,fname, lname, password) VALUES (?, ?, ?,?)";
        
        try {
        //    ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setBoolean(2, user.getActive());
            ps.setString(3,user.getFname());
            ps.setString(4,user.getLname());
            ps.setString(5,user.getPassword());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
          //  cp.freeConnection(con);
        }
    }

    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
     //   Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET email=?, active=? WHERE email=?";
        
        try {
          //  ps = con.prepareStatement(sql);
            ps.setBoolean(1, user.getActive());
            ps.setString(2, user.getFname());
            ps.setString(3, user.getLname());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            //cp.freeConnection(con);
        }
    }

    public void delete(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
    //    Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE email=?";
        
        try {
       //     ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
         //   cp.freeConnection(con);
        }
    }




}