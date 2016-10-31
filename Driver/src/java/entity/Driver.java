/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Driver {
    private int id;
    private String name;
    private String email;
    private String password;
    private String handphone;
    private String nric; 
    private ArrayList<Vehicle> vehicles;
    private String token;

    public Driver(int id, String name, String email, String password, String handphone, String nric, String token, ArrayList<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.handphone = handphone;
        this.nric = nric;
        this.token = token;
        this.vehicles = vehicles;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }
    
}
