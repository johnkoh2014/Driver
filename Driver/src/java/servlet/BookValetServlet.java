/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.OfferDAO;
import dao.WorkshopDAO;
import entity.Driver;
import entity.Offer;
import entity.Workshop;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
@WebServlet(name = "BookValetServlet", urlPatterns = {"/BookValet"})
public class BookValetServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        Driver user = (Driver) session.getAttribute("loggedInUser");
        OfferDAO oDAO = new OfferDAO();
        
        ArrayList<String> errMsg = new ArrayList<String>();

        String oId = request.getParameter("offerId");
        int offerId = 0;
        if (oId.length() > 0) {
            offerId = Integer.parseInt(oId);
        }

        int user_id = user.getId();

        String token = user.getToken();

        String wId = request.getParameter("workshopId");
        int workshopId = 0;
        if (wId.length() > 0) {
            workshopId = Integer.parseInt(wId);
        }

        String serviceStartTime = request.getParameter("serviceStartTime");

        String serviceEndTime = request.getParameter("serviceEndTime");

        String pickupTime = request.getParameter("pickupTime");
        
        String title = user.getName();

        String wsAddress = request.getParameter("wsAddress");
        
        String wsPostal = request.getParameter("wsPostal");
        
        String driverInitialComment = request.getParameter("driverInitialComment");

        //for sms details
        Offer offer = oDAO.retrieveOfferById(user_id, token, offerId);
        String servName = offer.getServiceName();
        
        WorkshopDAO wsDAO = new WorkshopDAO();
        Workshop ws = wsDAO.retrieveWorkshop(workshopId, user_id, token);
        String wsMobileNo = ws.getContact2();
        
        
        double dropoffLatitude = 0.0;
        double dropoffLongitude = 0.0;
        String[] latLong = oDAO.retrieveLatLong("Singapore("+wsPostal+")");
        if (latLong == null) {
            latLong = oDAO.retrieveLatLong("Singapore " + wsPostal);
            if (latLong == null) {
                errMsg.add("Please enter a valid address.");
            }
        } else {
            dropoffLatitude = Double.parseDouble(latLong[0]);
            dropoffLongitude = Double.parseDouble(latLong[1]);
        }

        String address = request.getParameter("address");
        String postal = request.getParameter("postal");

        double pickupLat = 0.0;
        double pickupLong = 0.0;
        String[] puLatLong = oDAO.retrieveLatLong("Singapore("+postal+")");
        if (puLatLong == null) {
            puLatLong = oDAO.retrieveLatLong("Singapore " + postal);
            if (puLatLong == null) {
                errMsg.add("Please enter a valid address.");
            }
        } else {
            pickupLat = Double.parseDouble(puLatLong[0]);
            pickupLong = Double.parseDouble(puLatLong[1]);
        }

        String priceString = request.getParameter("price");
        double price = Double.parseDouble(priceString);

        if (errMsg.size() > 0) {
            session.setAttribute("fail", errMsg);
            RequestDispatcher view = request.getRequestDispatcher("BookValet.jsp");
            view.forward(request, response);
        } else {
            
            String err = oDAO.acceptOfferWithValet(true, offerId, user_id, token, workshopId, serviceStartTime, serviceEndTime, title, address + " " + postal, pickupLat, 
                    pickupLong, wsAddress + " " + wsPostal, dropoffLatitude, dropoffLongitude, pickupTime, price);
//            String err = oDAO.acceptOfferWithoutValet(false, offerId, user_id, token, workshopId, serviceStartTime, serviceEndTime, title);

            if (err.length() > 0) {
                session.setAttribute("fail", err);
                RequestDispatcher view = request.getRequestDispatcher("BookValet.jsp");
                view.forward(request, response);
            } else {
                session.setAttribute("success", "Appointment booked at " + serviceStartTime);
                //add sms here
                SmsNotification smsNotification = new SmsNotification();
                smsNotification.smsForApptBooking(user.getName(), wsMobileNo, servName, serviceStartTime);
                response.sendRedirect("WaitingForValet.jsp");
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
        } catch (ParseException ex) {
            Logger.getLogger(BookValetServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(BookValetServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(BookValetServlet.class.getName()).log(Level.SEVERE, null, ex);
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
