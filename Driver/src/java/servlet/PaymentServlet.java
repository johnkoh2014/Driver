/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joshua
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String errorMsg = null;
            HttpSession session = request.getSession(true);
            /* TODO output your page here. You may use following sample code. */
            Stripe.apiKey = "sk_test_mzwWChaic4Q1JoBosXj4EWQl";

            // Get the credit card details submitted by the form
            String token = request.getParameter("stripeToken");

            // Create a charge: this will charge the user's card
            try {
                Map<String, Object> chargeParams = new HashMap<String, Object>();
                chargeParams.put("amount", 4000); // Amount in cents
                chargeParams.put("currency", "sgd");
                chargeParams.put("source", token);
                chargeParams.put("description", "Example charge");

                Charge charge = Charge.create(chargeParams);
                
                //Saving customer details for future payments--> insert code below here
                // YOUR CODE: Save the customer ID and other info in a database for later!
                
                // YOUR CODE: When it's time to charge the customer again, retrieve the customer ID!

            } catch (CardException e) {
                // Since it's a decline, CardException will be caught
                errorMsg = "Status is: " + e.getMessage();
                
            } catch (RateLimitException e) {
                // Too many requests made to the API too quickly
                errorMsg = "Status is: " + e.getMessage();
            } catch (InvalidRequestException e) {
                // Invalid parameters were supplied to Stripe's API
            } catch (AuthenticationException e) {
                // Authentication with Stripe's API failed
                // (maybe you changed API keys recently)
                errorMsg = "Status is: " + e.getMessage();
            } catch (APIConnectionException e) {
                // Network communication with Stripe failed
                errorMsg = "Status is: " + e.getMessage();
            } catch (StripeException e) {
                // Display a very generic error to the user, and maybe send
                // yourself an email
                errorMsg = "Status is: " + e.getMessage();
            } 

            if (errorMsg == null) {
                String successMsg = "Success!";
                session.setAttribute("successMsg", successMsg);
                session.setAttribute("token", token);
                response.sendRedirect("ValetBookingPayment.jsp");
            } else {
                session.setAttribute("errorMsg", errorMsg);
                session.setAttribute("token", token);
                response.sendRedirect("ValetBookingPayment.jsp");
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
