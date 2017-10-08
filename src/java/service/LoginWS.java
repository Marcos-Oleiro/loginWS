/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.ConnectionFactory;
import db.Users_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Marcos
 */
@WebService(serviceName = "LoginWS")
public class LoginWS {

    /**
     * This is a sample web service operation
     * @param txt
     * @param pass
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt, @WebParam(name = "pass") String pass) {

        Users_DAO dao = new Users_DAO();
        boolean aux = false;
        String resposta = null;
        aux = dao.Verifica(txt,pass);
//        aux = dao.Verifica(txt);
        if (aux)
            resposta = "Logado";
        else
            resposta = "Erro";
        
        
        return resposta;
        
    }
    
    @WebMethod (operationName = "adicionar")
    public String addUser (@WebParam (name = "name")String name, @WebParam (name = "pass")String pass){
        
        
        Users_DAO dao = new Users_DAO();
        boolean b = false;
        String retorno = "";
        b = dao.AddUser(name, pass);
        if(b)
            retorno = "Adicionado";
        else
            retorno = "Erro";
        return retorno;
       
        
    }
}
