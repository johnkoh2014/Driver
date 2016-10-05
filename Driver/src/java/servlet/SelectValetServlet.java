/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AppointmentDAO;
import dao.OfferDAO;
import entity.Driver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Driver user = (Driver) session.getAttribute("loggedInUser");

        String isValet = request.getParameter("valet");

        String oId = request.getParameter("offerId");
        int offerId = 0;
        if (oId.length() > 0) {
            offerId = Integer.parseInt(oId);
        }

        int user_id = user.getId();

        String token = user.getToken();

        String wId = request.getParameter("wId");
        int workshopId = 0;
        if (wId.length() > 0) {
            workshopId = Integer.parseInt(wId);
        }

        String serviceStartTime = request.getParameter("dateTime") + ":00:00";

        DateFormat df2 = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String[] dt = serviceStartTime.split(" ");
        String[] d = dt[0].split("-");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        String[] t = dt[1].split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        int sec = Integer.parseInt(t[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, hour, min, sec);

        cal.add(Calendar.HOUR_OF_DAY, 2);
        String serviceEndTime = cal.get(cal.YEAR) + "-" + cal.get(cal.MONTH) + "-" + cal.get(cal.DATE) + " " + cal.get(cal.HOUR_OF_DAY) + ":00:00";

        String title = user.getName();

        if (isValet.equals("true")) {
            session.setAttribute("isValet", isValet);
            session.setAttribute("offerId", offerId);
            session.setAttribute("workshopId", workshopId);
            session.setAttribute("serviceStartTime", serviceStartTime);
            session.setAttribute("serviceEndTime", serviceEndTime);

            response.sendRedirect("BookValet.jsp");
        } else {

            OfferDAO oDAO = new OfferDAO();
            String err = oDAO.acceptOfferWithoutValet(false, offerId, user_id, token, workshopId, serviceStartTime, serviceEndTime, title);
            
            if (err.length() > 0) {
                session.setAttribute("fail", err);
                RequestDispatcher view = request.getRequestDispatcher("Booking.jsp?id=" + offerId);
                view.forward(request, response);
            } else {
                session.setAttribute("success", "Appointment booked at " + serviceStartTime);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SelectValetServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SelectValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(SelectValetServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SelectValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
