/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AppointmentDAO;
import entity.Appointment;
import entity.Driver;
import entity.ValetRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "ProcessAppointmentsServlet", urlPatterns = {"/ProcessAppointments"})
public class ProcessAppointmentsServlet extends HttpServlet {

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
            throws ServletException, IOException, UnsupportedEncodingException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String vrStatus = request.getParameter("valetRequestStatus");
        int valetRequestStatus = 0;
        if (vrStatus != null && vrStatus.length() > 0) {
            valetRequestStatus = Integer.parseInt(vrStatus);
        }
        String oStatus = request.getParameter("offerStatus");
        int offerStatus = 0;
        if (oStatus != null && oStatus.length() > 0) {
            offerStatus = Integer.parseInt(oStatus);
        }
        String sId = request.getParameter("scheduleId");
        int scheduleId = 0;
        if (sId != null && sId.length() > 0) {
            scheduleId = Integer.parseInt(sId);
        }

        
        Driver user = (Driver) session.getAttribute("loggedInUser");
        AppointmentDAO aDAO = new AppointmentDAO();
        Appointment appointment = aDAO.getAppointmentById(user.getId(), user.getToken(), scheduleId);
        ValetRequest vr = appointment.getToValet();
        valetRequestStatus = vr.getStatus();
        
        session.setAttribute("valetRequestStatus", valetRequestStatus);
        session.setAttribute("offerStatus", offerStatus);
        session.setAttribute("scheduleId", scheduleId);
        String url = "MyAppointments.jsp";
        if (valetRequestStatus == 1) {
            url = "WaitingForValet.jsp";
        } else if (valetRequestStatus == 2) {
            url = "ValetAssigned.jsp";
        } else if (valetRequestStatus == 3 || valetRequestStatus == 4 || valetRequestStatus == 5 || valetRequestStatus == 6) {
            url = "ViewValetStatus.jsp";
        } else if (valetRequestStatus == 7) {
            if (offerStatus == 3 || offerStatus == 4) {
                url = "WorkshopDiagnosis.jsp";
            } else if (offerStatus == 5 || offerStatus == 6) {
                url = "WorkshopStartServicing.jsp";
            } else if (offerStatus == 7) {
                url = "WorkshopCompleteServicing.jsp";
            }
        }
        response.sendRedirect(url);
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProcessAppointmentsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProcessAppointmentsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
