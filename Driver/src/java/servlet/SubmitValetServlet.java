/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AppointmentDAO;
import dao.DriverDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "SubmitValetServlet", urlPatterns = {"/SubmitValet"})
public class SubmitValetServlet extends HttpServlet {

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
        String pickUpAddress = request.getParameter("address");
        String pickUpPostal = request.getParameter("postal");
        String wsAddress = request.getParameter("wsAddress");
        String appointmentTime = request.getParameter("serviceStartTime");
        String serviceEndTime = request.getParameter("serviceEndTime");
        String workshopId = request.getParameter("workshopId");
        String offerId = request.getParameter("offerId");
        String driverInitialComment = request.getParameter("driverInitialComment");

        Validation validation = new Validation();
        String isValidPostal = validation.isValidPostalCode(pickUpPostal);
        if (isValidPostal != null) {
            request.setAttribute("errMsg", isValidPostal);
            RequestDispatcher view = request.getRequestDispatcher("ValetForm.jsp");
            view.forward(request, response);
        }

        Timestamp appointmentStart = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(appointmentTime);
        appointmentStart = new java.sql.Timestamp(parsedDate.getTime());

        AppointmentDAO aDAO = new AppointmentDAO();
        Timestamp pickupTime = aDAO.calculatePickUpTime(pickUpAddress + " " + pickUpPostal, wsAddress, appointmentStart);
        if (pickupTime == null) {
            request.setAttribute("errMsg", "Invalid Address/Postal");
            RequestDispatcher view = request.getRequestDispatcher("ValetForm.jsp");
            view.forward(request, response);
        } else {
            session.setAttribute("appointmentTime", appointmentStart);
            session.setAttribute("serviceEndTime", serviceEndTime);
            session.setAttribute("pickupTime", pickupTime);
            session.setAttribute("workshopId", workshopId);
            session.setAttribute("offerId", offerId);
            session.setAttribute("wsAddress", wsAddress);
            session.setAttribute("pickUpAddress", pickUpAddress);
            session.setAttribute("pickUpPostal", pickUpPostal);
            session.setAttribute("driverInitialComment", driverInitialComment);
            response.sendRedirect("BookValet.jsp");
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
            Logger.getLogger(SubmitValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SubmitValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
