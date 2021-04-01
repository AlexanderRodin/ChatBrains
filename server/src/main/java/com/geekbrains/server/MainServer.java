package com.geekbrains.server;

import java.sql.*;

public class MainServer {

    public static void main(String[] args) throws SQLException {
        new DbHandler();
        new Server();
    }
}


