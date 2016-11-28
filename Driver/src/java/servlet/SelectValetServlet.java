/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AppointmentDAO;
import dao.OfferDAO;
import dao.WorkshopDAO;
import entity.Driver;
import entity.Offer;
import entity.Workshop;
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
import util.SmsNotification;

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
        OfferDAO oDAO = new OfferDAO();
        
        String isValet = request.getParameter("valet");
        String driverInitialComment = request.getParameter("comment");

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


//        String dateTimeString = request.getParameter("dateTime") + ":00:00";
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        
        String serviceStartTime = null;
        String serviceEndTime = null;
        if (time != null) {
            String startTime = time.substring(0, time.indexOf(" -")) + ":00";
            startTime = startTime.trim();
            String endTime = time.substring(time.lastIndexOf(" ") + 1) + ":00";
            endTime = endTime.trim();
            serviceStartTime = date + " " + startTime;
            serviceEndTime = date + " " + endTime;
        }
        
        
        
//        String hours = time.substring(0, time.indexOf(":"));
//        int hoursInt = Integer.parseInt(hours);
//        String mins = time.substring(time.indexOf(":") + 1, time.lastIndexOf(" "));
//        String ampm = time.substring(time.lastIndexOf(" ") + 1);
//        
//        if(ampm.equals("PM")){
//            hoursInt += 12;
//            hours = hoursInt + "";
//        } else {
//            if(hoursInt < 10){
//                hours = "0" + hours;
//            }
//        }
//        String dateTimeString = date + " " + hours + ":" + mins + ":00";

        //for sms
        Offer offer = oDAO.retrieveOfferById(user_id, token, offerId);
        String servName = offer.getServiceName();
        
        WorkshopDAO wsDAO = new WorkshopDAO();
        Workshop ws = wsDAO.retrieveWorkshop(workshopId, user_id, token);
        String wsMobileNo = ws.getContact2();
        
//        String dateTimeString = request.getParameter("dateTime") + ":00:00";
//        Timestamp startTime = null;
//        Timestamp later = null;
//
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date parsedDate = dateFormat.parse(dateTimeString);
//            startTime = new java.sql.Timestamp(parsedDate.getTime());
//
//            Calendar cal = Calendar.getInstance();
//            cal.setTimeInMillis(startTime.getTime());
//
//            //Subtract the time taken to reach the drop off point from the appointment time
//            cal.add(Calendar.MINUTE, 30);
//
//            //Round down the time to the nearest 15 minute
//            later = new Timestamp(cal.getTime().getTime());
//        } catch (Exception e) {
//        }
//        String serviceStartTime = dateTimeString;
//        String serviceEndTime = later + "";
//        serviceEndTime = serviceEndTime.substring(0, serviceEndTime.lastIndexOf("."));
        
        String title = user.getName();

        if (isValet.equals("true")) {
            session.setAttribute("isValet", isValet);
            session.setAttribute("offerId", offerId);
            session.setAttribute("workshopId", workshopId);
            session.setAttribute("serviceStartTime", serviceStartTime);
            session.setAttribute("serviceEndTime", serviceEndTime);
            session.setAttribute("driverInitialComment", driverInitialComment);

            response.sendRedirect("ValetForm.jsp");
        } else {

            oDAO = new OfferDAO();
            String err = oDAO.acceptOfferWithoutValet(false, offerId, user_id, token, workshopId, serviceStartTime, serviceEndTime, title, driverInitialComment);

            if (err.length() > 0) {
                request.setAttribute("fail", err);
                RequestDispatcher view = request.getRequestDispatcher("Booking.jsp?id=" + offerId);
                view.forward(request, response);
            } else {
                session.setAttribute("success", "Appointment booked at " + serviceStartTime);
                //add sms here
                SmsNotification smsNotification = new SmsNotification();
                smsNotification.smsForApptBooking(user.getName(), wsMobileNo, servName, serviceStartTime);
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
