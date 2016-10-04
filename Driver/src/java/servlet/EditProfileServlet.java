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
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfile"})
public class EditProfileServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email").trim();
        String name = request.getParameter("name").trim();
        String hpNo = request.getParameter("hpNo").trim();

        Validation validation = new Validation();
        String errMsg = validation.isValidMobileContact(hpNo);

        HttpSession session = request.getSession(true);

        if (errMsg == null || errMsg.length() == 0) {
            DriverDAO dDAO = new DriverDAO();
            Driver user = (Driver) session.getAttribute("loggedInUser");
            int id = user.getId();

            String token = user.getToken();
            String error = dDAO.updateDriver(id, token, name, hpNo);
            if (error == null || error.length() == 0) {
                session.setAttribute("success", "Successfully edited profile");
                user.setName(name);
                user.setHandphone(hpNo);
                session.setAttribute("loggedInUser", user);
                response.sendRedirect("Profile.jsp");
            } else {
                request.setAttribute("fail", error);
                RequestDispatcher view = request.getRequestDispatcher("EditProfile.jsp");
                view.forward(request, response);
            }
        } else {
            request.setAttribute("fail", errMsg);
            RequestDispatcher view = request.getRequestDispatcher("EditProfile.jsp");
            view.forward(request, response);
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
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
