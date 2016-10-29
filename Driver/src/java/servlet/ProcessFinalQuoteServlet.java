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
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
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
@WebServlet(name = "ProcessFinalQuoteServlet", urlPatterns = {"/ProcessFinalQuote"})
public class ProcessFinalQuoteServlet extends HttpServlet {

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
            throws ServletException, IOException, UnsupportedEncodingException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        String status = request.getParameter("accept");
        String oId = request.getParameter("offerId");
        int offerId = Integer.parseInt(oId);
        OfferDAO oDAO = new OfferDAO();
        Driver user = (Driver) session.getAttribute("loggedInUser");
        int userId = user.getId();
        String token = user.getToken();
        
        //to retrieve details for sms
        Offer offer = oDAO.retrieveOfferById(userId, token, offerId);
        int workshopId = offer.getWorkshopId();
        WorkshopDAO wsDAO = new WorkshopDAO();
        Workshop ws = wsDAO.retrieveWorkshop(workshopId, userId, token);
        String mobileNo = ws.getContact2();
       
        String custName = user.getName();
        
        String vNum = offer.getVehicle().getPlateNumber();
        
        
        if(status.equals("accept")){
            String error = oDAO.acceptFinalQuotation(userId, token, offerId);
            if (error.length() > 0) {
                    request.setAttribute("fail", error);   
                    RequestDispatcher view = request.getRequestDispatcher("WorkshopDiagnosis.jsp");
                    view.forward(request, response);
                } else {
                    session.setAttribute("success", "Final Quotation Accepted");
                    SmsNotification smsNotification = new SmsNotification();
                    smsNotification.smsForAcceptFinal(custName, mobileNo, vNum);
                    response.sendRedirect("WorkshopStartServicing.jsp");
                }
        } else {
            String error = oDAO.rejectFinalQuotation(userId, token, offerId);
            if (error.length() > 0) {
                request.setAttribute("fail", error);   
                RequestDispatcher view = request.getRequestDispatcher("WorkshopDiagnosis.jsp");
                view.forward(request, response);
            } else {
                session.setAttribute("success", "Final Quotation Rejected");
                SmsNotification smsNotification = new SmsNotification();
                smsNotification.smsForRejectFinal(custName, mobileNo, vNum);
                response.sendRedirect("Request.jsp");
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
            throws ServletException, IOException, UnsupportedEncodingException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ProcessFinalQuoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessFinalQuoteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProcessFinalQuoteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessFinalQuoteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
