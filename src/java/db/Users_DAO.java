/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.LoginWS;

/**
 *
 * @author Marcos
 */
public class Users_DAO {

    public boolean Verifica(String name, String pass) {

        String sql = "SELECT name FROM users WHERE senha = ?";
        Connection con = new ConnectionFactory().getConnection();
        String nome;
        nome = null;
        try {
            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, "pass1");
            st.setString(1, pass);
            ResultSet rs = null;
            rs = st.executeQuery();
            if (rs.next()) {
                nome = rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginWS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return name.equals(nome);
    }
    
    
    public boolean AddUser(String name, String pass){
        
        try {
            String sql = "INSERT INTO users VALUES (default,?,?)";
            
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            int x = 0;
            x= st.executeUpdate();
            return x==1;            
        } catch (SQLException ex) {
            Logger.getLogger(Users_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
}