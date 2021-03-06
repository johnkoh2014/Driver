/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class Appointment {

    private int id;
    private int shopId;
    private Timestamp appointmentStart;
    private Timestamp appointmentEnd;
    private String appointmentTitle;
    private ValetRequest toValet;
    private ValetRequest returnValet;
    private String shopName;
    private int offerStatus;
    private ValetDriver valetDriver;
    private Workshop workshop;
    private double serviceFinalPrice;
    private Timestamp serviceEstCompleteTime;
    private String wsInitialComment;
    private String driverInitialComment;
    private String wsFinalComment;

    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd, String shopName, int offerStatus) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.shopName = shopName;
        this.offerStatus = offerStatus;
    }

    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd, ValetRequest toValet, String shopName, int offerStatus) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.toValet = toValet;
        this.shopName = shopName;
        this.offerStatus = offerStatus;
    }

    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd, ValetRequest toValet, ValetRequest returnValet, String shopName, int offerStatus) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.toValet = toValet;
        this.returnValet = returnValet;
        this.shopName = shopName;
        this.offerStatus = offerStatus;
    }

    public Appointment(int id, Timestamp appointmentStart, Timestamp appointmentEnd, String appointmentTitle, ValetRequest toValet, ValetDriver valetDriver, Workshop workshop, double serviceFinalPrice, Timestamp serviceEstCompleteTime, int offerStatus, String wsInitialComment, String driverInitialComment, String wsFinalComment) {
        this.id = id;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.appointmentTitle = appointmentTitle;
        this.toValet = toValet;
        this.valetDriver = valetDriver;
        this.workshop = workshop;
        this.serviceFinalPrice = serviceFinalPrice;
        this.serviceEstCompleteTime = serviceEstCompleteTime;
        this.offerStatus = offerStatus;
        this.wsInitialComment = wsInitialComment;
        this.driverInitialComment = driverInitialComment;
        this.wsFinalComment = wsFinalComment;
    }

    public int getId() {
        return id;
    }

    public int getShopId() {
        return shopId;
    }

    public Timestamp getAppointmentStart() {
        return appointmentStart;
    }

    public Timestamp getAppointmentEnd() {
        return appointmentEnd;
    }

    public ValetRequest getToValet() {
        return toValet;
    }

    public ValetRequest getReturnValet() {
        return returnValet;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(int offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public ValetDriver getValetDriver() {
        return valetDriver;
    }

    public void setValetDriver(ValetDriver valetDriver) {
        this.valetDriver = valetDriver;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public double getServiceFinalPrice() {
        return serviceFinalPrice;
    }

    public void setServiceFinalPrice(double serviceFinalPrice) {
        this.serviceFinalPrice = serviceFinalPrice;
    }

    public Timestamp getServiceEstCompleteTime() {
        return serviceEstCompleteTime;
    }

    public void setServiceEstCompleteTime(Timestamp serviceEstCompleteTime) {
        this.serviceEstCompleteTime = serviceEstCompleteTime;
    }

    public String getWsInitialComment() {
        return wsInitialComment;
    }

    public void setWsInitialComment(String wsInitialComment) {
        this.wsInitialComment = wsInitialComment;
    }

    public String getDriverInitialComment() {
        return driverInitialComment;
    }

    public void setDriverInitialComment(String driverInitialComment) {
        this.driverInitialComment = driverInitialComment;
    }

    public String getWsFinalComment() {
        return wsFinalComment;
    }

    public void setWsFinalComment(String wsFinalComment) {
        this.wsFinalComment = wsFinalComment;
    }
    

}
