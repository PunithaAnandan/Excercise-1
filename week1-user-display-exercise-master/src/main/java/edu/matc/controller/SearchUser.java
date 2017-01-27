package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> usersList = null;
        String searchTerm = req.getParameter("searchTerm");
        String searchType = req.getParameter("searchType");
        logger.info("doGet Start");
        try {
            UserData userData = new UserData();
            if ("lastName".equals(searchType)) {
                usersList = userData.getUsersByLastName(searchTerm);
            } else if ("All".equals(searchType)) {
                usersList = userData.getAllUsers();
            }

        } catch(Exception exception){
            logger.debug("General error:" + exception.getStackTrace().toString());

        }

        //PrintWriter out = resp.getWriter();
        //out.println(lastName);
        req.setAttribute("title", "Users Table");
        req.setAttribute("users", usersList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        logger.info("doGet End");
        dispatcher.forward(req, resp);
    }
}