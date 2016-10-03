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
    private ValetRequest toValet;
    private ValetRequest returnValet;
    
    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
    }
    
    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd, ValetRequest toValet) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.toValet = toValet;
    }
    
    public Appointment(int id, int shopId, Timestamp appointmentStart, Timestamp appointmentEnd, ValetRequest toValet, ValetRequest returnValet) {
        this.id = id;
        this.shopId = shopId;
        this.appointmentStart = appointmentStart;
        this.appointmentEnd = appointmentEnd;
        this.toValet = toValet;
        this.returnValet = returnValet;
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
}
