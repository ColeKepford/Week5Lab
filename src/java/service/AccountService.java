/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import users.User;

/**
 *
 * @author cocog
 */
public class AccountService 
{
    private String usermame;
    private String password;
    
    public AccountService()
    {
        
    }
    
    public User login(String username, String password)
    {
        if(username.equals("abe") || username.equals("barb") && password.equals("password"))
        {
            User user = new User(username, password);
            return user;
        }
        return null;
    }
}
