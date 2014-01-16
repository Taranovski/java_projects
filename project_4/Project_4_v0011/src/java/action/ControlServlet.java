package action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static constants.CommandsConstants.COMMAND;
import infrastructure.Command;
import infrastructure.CommandFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * control servlet
 * @author Alex
 */
@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

        try (PrintWriter out = response.getWriter()) {
            //get command
            String stringCommand = request.getParameter(COMMAND.toString());
            Logger.getLogger(ControlServlet.class.getName()).info(stringCommand);
            //get redirection page
            Command command = CommandFactory.instance().getCommand(stringCommand);
            String redirect = command.execute(request, response);
            //forwarding
            Logger.getLogger(ControlServlet.class.getName()).info(redirect);
            request.getRequestDispatcher(redirect).forward(request, response);

        } catch (IOException | ServletException ex) {
            Logger.getLogger(ControlServlet.class.getName()).error(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
