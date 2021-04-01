package com.geekbrains.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService extends DbHandler implements AuthService {



         public SimpleAuthService() throws SQLException {}


        @Override
        public String getNicknameByLoginAndPassword(String login, String password) {
               if(authorization(login, password) == true){return login;}
                return null;
                }
        }
