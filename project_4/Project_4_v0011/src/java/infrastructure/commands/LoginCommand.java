/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure.commands;

import static constants.DBConstants.DB_MYSQL;
import static constants.ForwardConstants.FORWARD_ADMIN;
import static constants.ForwardConstants.FORWARD_INDEX;
import static constants.ForwardConstants.FORWARD_USER;
import static constants.RequestParametersConstants.REQUEST_LOGIN_ERROR;
import static constants.RequestParametersConstants.REQUEST_PASSWORD;
import static constants.RequestParametersConstants.REQUEST_USER;
import static constants.RequestParametersConstants.REQUEST_USER_NAME;
import static constants.UserRoleConstants.USER_ROLE_ADMIN;
import static constants.UserRoleConstants.USER_ROLE_CLIENT;
import dao.abstr.UserDAO;
import dao.abstr.sup.DAOFactory;
import data.User;
import infrastructure.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * login command
 * @author Тарановский
 */
public class LoginCommand implements Command {

    /**
     * constructor
     */
    public LoginCommand() {
    }

    /**
     * authenticate the user
     *
     * @param request from servlet
     * @param response to servlet
     * @return if user is in the database and his password is correct
     */
    private boolean authenticate(HttpServletRequest request,
            HttpServletResponse response) {

        boolean authentication = false;

        String user = request.getParameter(REQUEST_USER_NAME.toString());
        String pass = request.getParameter(REQUEST_PASSWORD.toString());

        UserDAO userDao = DAOFactory.getFactory(DB_MYSQL).createUserDAO();
        User authUser = userDao.getUser(user, pass);

        if (authUser != null) {

            request.getSession(true).setAttribute(REQUEST_USER.toString(), authUser);

            authentication = true;
        }
        return authentication;

    }

    /**
     * execute command
     *
     * @param request from servlet
     * @param response to servlet
     * @return forward adress string
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (authenticate(request, response)) {
            User authUser = (User) request.getSession().getAttribute(REQUEST_USER.toString());
            int role = authUser.getRole();

            if (role == USER_ROLE_CLIENT.getRole()) {
                return FORWARD_USER.toString();
            }
            if (role == USER_ROLE_ADMIN.getRole()) {
                return FORWARD_ADMIN.toString();
            }
        }
        request.setAttribute(REQUEST_LOGIN_ERROR.toString(), REQUEST_LOGIN_ERROR.toString());
        return FORWARD_INDEX.toString();
    }
}
