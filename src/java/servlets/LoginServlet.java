/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountService;
import users.User;

/**
 *
 * @author cocog
 */
public class LoginServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) 
        {
            request.setAttribute("message", "User logged out");
            session.invalidate();
            session = request.getSession();
        }
        
        else if(user != null)
        {
            response.sendRedirect("home");
            return;
        }
      
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username != null && password != null)
        {
            AccountService accService = new AccountService();
            
            if(accService.login(username, password) != null)
            {
                user = accService.login(username, password);
                session.setAttribute("user", user);
                
                response.sendRedirect("home");
            }
            else
            {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("message", "Invalid Credentials");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
    }
}
