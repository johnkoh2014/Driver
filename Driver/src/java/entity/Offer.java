/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author Joanne
 */
public class Offer {

    private int id;
    private int serviceId;
    private Timestamp estCompletionTime;
    private double finalPrice;
    private int workshopId;
    private String shopName;
    private String serviceName;
    private String shopAddress;
    private String shopCategory;
    private String contact;
    private String contact1;
    private String contact2;
    private int status;
    private double initialMinPrice;
    private double initialMaxPrice;
    private double diagnosticPrice;
    private String openingHour; 
    private String brandsCarried; 
    private String website; 
    private Vehicle vehicle;

    public Offer(int id, int serviceId, double finalPrice, int workshopId, String shopName, String contact1, String contact2, int status, double initialMinPrice, double initialMaxPrice, double diagnosticPrice) {
        this.id = id;
        this.serviceId = serviceId;
        this.finalPrice = finalPrice;
        this.workshopId = workshopId;
        this.shopName = shopName;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.status = status;
        this.initialMinPrice = initialMinPrice;
        this.initialMaxPrice = initialMaxPrice;
        this.diagnosticPrice = diagnosticPrice;
    }

    public Offer(int id, String shopName, String contact, int workshopId, double finalPrice, double initialMinPrice, double initialMaxPrice, double diagnosticPrice, int status) {
        this.id = id;
        this.shopName = shopName;
        this.contact = contact;
        this.workshopId = workshopId;
        this.finalPrice = finalPrice;
        this.shopName = shopName;
        this.finalPrice = finalPrice;
        this.initialMinPrice = initialMinPrice;
        this.initialMaxPrice = initialMaxPrice;
        this.diagnosticPrice = diagnosticPrice;
        this.status = status;
    }

    public Offer(int id, int serviceId, String serviceName, String openingHour, int workshopId, String shopName, String shopAddress, String shopCategory, String brandsCarried, String website, int status, double initialMinPrice, double initialMaxPrice, double diagnosticPrice, double finalPrice, Timestamp estCompletionTime) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.workshopId = workshopId;
        this.shopName = shopName;
        this.openingHour = openingHour;
        this.shopAddress = shopAddress;
        this.shopCategory = shopCategory;
        this.status = status;
        this.brandsCarried = brandsCarried;
        this.website = website;
        this.finalPrice = finalPrice;
        this.initialMinPrice = initialMinPrice;
        this.initialMaxPrice = initialMaxPrice;
        this.diagnosticPrice = diagnosticPrice;
        this.estCompletionTime = estCompletionTime;
    }

    public Offer(int id, int serviceId, String serviceName, String openingHour, int workshopId, String shopName, String shopAddress, String shopCategory, String brandsCarried, String website, int status, double initialMinPrice, double initialMaxPrice, double diagnosticPrice, double finalPrice, Timestamp estCompletionTime, Vehicle vehicle) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.workshopId = workshopId;
        this.shopName = shopName;
        this.openingHour = openingHour;
        this.shopAddress = shopAddress;
        this.shopCategory = shopCategory;
        this.status = status;
        this.brandsCarried = brandsCarried;
        this.website = website;
        this.finalPrice = finalPrice;
        this.initialMinPrice = initialMinPrice;
        this.initialMaxPrice = initialMaxPrice;
        this.diagnosticPrice = diagnosticPrice;
        this.estCompletionTime = estCompletionTime;
        this.vehicle = vehicle;
    }

    public String getBrandsCarried() {
        return brandsCarried;
    }

    public void setBrandsCarried(String brandsCarried) {
        this.brandsCarried = brandsCarried;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public Timestamp getEstCompletionTime() {
        return estCompletionTime;
    }

    public void setEstCompletionTime(Timestamp estCompletionTime) {
        this.estCompletionTime = estCompletionTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(int workshopId) {
        this.workshopId = workshopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getInitialMinPrice() {
        return initialMinPrice;
    }

    public void setInitialMinPrice(double initialMinPrice) {
        this.initialMinPrice = initialMinPrice;
    }

    public double getInitialMaxPrice() {
        return initialMaxPrice;
    }

    public void setInitialMaxPrice(double initialMaxPrice) {
        this.initialMaxPrice = initialMaxPrice;
    }

    public double getDiagnosticPrice() {
        return diagnosticPrice;
    }

    public void setDiagnosticPrice(double diagnosticPrice) {
        this.diagnosticPrice = diagnosticPrice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
