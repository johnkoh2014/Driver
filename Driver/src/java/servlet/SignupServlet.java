/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DriverDAO;
import entity.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Validation;

/**
 *
 * @author User
 */
@WebServlet(name = "SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String passwordEntered = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String handphone = request.getParameter("handphone");      
        
        Validation validation = new Validation();
        String err = validation.isValidPassword(passwordEntered, confirmPassword);
        ArrayList<String> errors = new ArrayList<String>();
        
        if (err != null && err.length() > 0) {
            errors.add(err);
            request.setAttribute("fullname", fullname);
            request.setAttribute("email", email);
            request.setAttribute("err", errors);
            RequestDispatcher view = request.getRequestDispatcher("Signup.jsp");
            view.forward(request, response);
        } else {
            DriverDAO driverDAO = new DriverDAO();
            errors = driverDAO.addDriver(fullname, email, passwordEntered, handphone);
            if (errors == null || errors.size() == 0) {
                Driver user = driverDAO.authenticateUser(email, passwordEntered);
                session.setAttribute("loggedInUser", user);
                response.sendRedirect("Request.jsp");
            } else {
                RequestDispatcher view = request.getRequestDispatcher("Signup.jsp");
                request.setAttribute("fullname", fullname);
                request.setAttribute("email", email);
                request.setAttribute("handphone", handphone);
                request.setAttribute("err", errors);
                view.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
