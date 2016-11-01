/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DriverDAO;
import dao.VehicleDAO;
import entity.Driver;
import entity.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AddVehicleServlet", urlPatterns = {"/AddVehicle"})
public class AddVehicleServlet extends HttpServlet {

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
        String carMake = request.getParameter("carMake");
        String carModel = request.getParameter("carModel");
        String aManufactureYear = request.getParameter("manufactureYear");
        int manufactureYear = Integer.parseInt(aManufactureYear);
        String plateNumber = request.getParameter("plateNumber");
        String carColor = request.getParameter("carColor");
        String transmission = request.getParameter("transmission");

        //Logged in user details
        HttpSession session = request.getSession(true);
        Driver user = (Driver) session.getAttribute("loggedInUser");
        VehicleDAO vDAO = new VehicleDAO();
        int user_id = user.getId();
        String token = user.getToken(); 
        
        ArrayList<String> errorMsg = vDAO.addVehicle(carMake, carModel, manufactureYear, user_id, plateNumber, token, carColor, transmission);
        int vid = 0;
        if (errorMsg.size() == 1) {
            try {
                vid = Integer.parseInt(errorMsg.get(0));
                session.setAttribute("vid", vid+"");
                response.sendRedirect("Service.jsp");
            } catch (NumberFormatException e) {
                request.setAttribute("errMsg", errorMsg);
                RequestDispatcher view = request.getRequestDispatcher("AddVehicle.jsp");
                view.forward(request, response);
            }
        } else {
            request.setAttribute("errMsg", errorMsg);
            RequestDispatcher view = request.getRequestDispatcher("AddVehicle.jsp");
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
