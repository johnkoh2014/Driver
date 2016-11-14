/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author joanne.ong.2014
 */
public class ValetDriver {

    private int staffId;
    private String email;
    private String handphone;
    private String name;
    private String valetPicture;

    
    public ValetDriver(int staffId, String email, String name, String handphone, String valetPicture) {
        this.staffId = staffId;
        this.email = email;
        this.handphone = handphone;
        this.name = name;
        this.valetPicture = valetPicture;
    }
    
    //getter methods
    /**
     * Returns the email.
     *
     * @return the email
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * Returns the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getHandphone() {
        return handphone;
    }

    public String getValetPicture() {
        return valetPicture;
    }

    public void setValetPicture(String valetPicture) {
        this.valetPicture = valetPicture;
    }
    
}
