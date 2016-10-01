/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Joanne
 */
public class QuotationRequest {

    private int id;
    private String name;
    private String details;
    private String mileage;
    private String urgency;
    private String amenities;
    private double latitude;
    private double longitude;
    private String address;
    private Timestamp requestedDate;
    private String category;
    private int noOfRejections;
    private int no_of_offers;
    private int read;
    private int vehicleId;
    private ArrayList<Offer> offer;

    public QuotationRequest(int id, String name, String details, String mileage, String urgency, String amenities, double latitude, double longitude, String address, Timestamp requestedDate, String category, int noOfRejections, int no_of_offers, int read, int vehicleId, ArrayList<Offer> offer) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.mileage = mileage;
        this.urgency = urgency;
        this.amenities = amenities;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.requestedDate = requestedDate;
        this.category = category;
        this.noOfRejections = noOfRejections;
        this.no_of_offers = no_of_offers;
        this.read = read;
        this.vehicleId = vehicleId;
        this.offer = offer;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Timestamp requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNoOfRejections() {
        return noOfRejections;
    }

    public void setNoOfRejections(int noOfRejections) {
        this.noOfRejections = noOfRejections;
    }

    public int getNo_of_offers() {
        return no_of_offers;
    }

    public void setNo_of_offers(int no_of_offers) {
        this.no_of_offers = no_of_offers;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ArrayList<Offer> getOffer() {
        return offer;
    }

    public void setOffer(ArrayList<Offer> offer) {
        this.offer = offer;
    }

}
