/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AppointmentDAO;
import entity.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "SelectValetServlet", urlPatterns = {"/SelectValet"})
public class SelectValetServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String dateTime = request.getParameter("dateTime") + ":00:00";
        String valet = request.getParameter("valet");
        String oId = request.getParameter("offerId");
        int offerId = 0;
        if (oId.length() > 0) {
            offerId = Integer.parseInt(oId);
        }
        String wId = request.getParameter("wId");
        int workshopId = 0;
        if (wId.length() > 0) {
            workshopId = Integer.parseInt(wId);
        }
        HttpSession session = request.getSession(true);
        Driver user = (Driver) session.getAttribute("loggedInUser");
        String token = user.getToken();
        String name = user.getName();
        int user_id = user.getId();
        Timestamp ts = Timestamp.valueOf(dateTime);

        if (valet.equals("Yes")) {
            session.setAttribute("valet", valet);
            session.setAttribute("dateTime", dateTime);
            response.sendRedirect("BookValet.jsp");
        } else {
            session.setAttribute("valet", valet);
            session.setAttribute("dateTime", dateTime);
            AppointmentDAO aDAO = new AppointmentDAO();
            String err = aDAO.addAppointment(user_id, token, workshopId, name, dateTime, dateTime, offerId);
            if (err.length() > 0) {
                session.setAttribute("fail", err);
                RequestDispatcher view = request.getRequestDispatcher("Booking.jsp?id=" + offerId);
                view.forward(request, response);
            } else {
                session.setAttribute("success", "Appointment booked at " + dateTime);
                response.sendRedirect("MyAppointments.jsp");
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
        processRequest(request, response);
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
