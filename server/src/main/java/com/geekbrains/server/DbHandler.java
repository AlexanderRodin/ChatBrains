package com.geekbrains.server;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbHandler {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DbHandler() throws SQLException {
        boolean start = dbStart();
        System.out.println("Connection DB is "+start);

    }



    public boolean dbStart(){
         {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:ChatDB.db");
                statement = connection.createStatement();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
       return connection!=null;
    }


    public boolean authorization (String login, String userPassword){
    boolean auth = false;
    try {
        resultSet = statement.executeQuery("SELECT * FROM identification");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String pass = resultSet.getString("pass");
            if(name.equals(login) & pass.equals(userPassword)){return true;}
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return false;
}


    public void loginUpdate(String thisName, String newName){
        try {
            resultSet = statement.executeQuery("UPDATE identification SET name = "+newName+" WHERE name = "+thisName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





//    public boolean authorization (String login, String userPassword){
//
//
//        try {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String pass = resultSet.getString("pass");
//                System.out.println(id + " " + name + " " + pass);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }

}
