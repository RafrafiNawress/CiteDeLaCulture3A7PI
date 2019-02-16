/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nawre
 */
public class MyDB {

    String url = "jdbc:mysql://127.0.0.1:3306/culturecitybd";
    String login = "root";
    String password = "";
    private Connection connexion;
    private static MyDB instance;
    private MyDB() {
        try {
            
            connexion = DriverManager
                    .getConnection(url, login, password);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion");
        }
        
    }

    public Connection getConnexion() {
        return connexion;
    }
    
    public static MyDB getInstance(){
        if(instance ==null)
            instance =new MyDB();
        
        return instance;
    }
    
    
}


