/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.VehicleDAO;
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
@WebServlet(name = "EditVehicleServlet", urlPatterns = {"/EditVehicle"})
public class EditVehicleServlet extends HttpServlet {

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

        String carMake = request.getParameter("carMake").trim();
        String carModel = request.getParameter("carModel").trim();
        String manufactureYear = request.getParameter("manufactureYear").trim();
        int year = 0;
        if (manufactureYear != null && manufactureYear.length() > 0) {
            year = Integer.parseInt(manufactureYear);
        }
        String plateNumber = request.getParameter("plateNumber").trim();
        String carColor = request.getParameter("carColor").trim();
        String transmission = request.getParameter("transmission").trim();
        String ownerNric = request.getParameter("ownerNric").trim();
        String chassisNum = request.getParameter("chassisNum").trim();
        String v_id = request.getParameter("vid");
        int vid = 0;
        if (v_id != null && v_id.length() > 0){
            vid = Integer.parseInt(v_id);
        }
        //Logged in user details
        HttpSession session = request.getSession(true);
        Driver user = (Driver) session.getAttribute("loggedInUser");
        VehicleDAO vDAO = new VehicleDAO();
        int user_id = user.getId();
        String token = user.getToken();

        ArrayList<String> errorMsg = vDAO.editVehicle(vid, carMake, carModel, year, user_id, plateNumber, token, carColor, transmission, ownerNric, chassisNum);

        if (errorMsg == null || errorMsg.isEmpty()) {
//            Vehicle vehicle = new Vehicle(user_id, token, token, user_id, plateNumber, user_id, carColor, token);
//            (int id, String make, String model, int year, String plateNumber, int customerID, String colour, String control)
            session.setAttribute("success", carMake + " " + carModel + " edited");
            response.sendRedirect("Profile.jsp");
        } else {
            request.setAttribute("errMsg", errorMsg); 
            RequestDispatcher view = request.getRequestDispatcher("EditVehicle.jsp?id=" + vid); 
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
            Logger.getLogger(EditVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
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
