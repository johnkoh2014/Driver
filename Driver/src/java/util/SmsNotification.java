/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.net.*;
import java.io.*;

/**
 *
 * @author Desmond
 */
public class SmsNotification { //for workshops to receive
    String uniqueLink = ""; //extract unique link for customer here
    String username = "Fixir"; //bulksms username
    String password = "fixir2016"; //bulksms password
    String senderId = "FIXIR"; //sender's name appearing on customer's mobile phone
    String mobileTest = "";  //REMEMBER TO CHANGE ALL MOBILETEST TO MOBILE NO IN THE CODES BELOW 
    
    //mobile number must all add "65" in front!!!
    //user:Fixir  
    //pass:fixir2016
    
    
    //note that this is for workshop to receive NOT DONE 
    public void smsForApptBooking(String custName, String mobileNo, String servDesc, String apptDateTime){
        try {
            // Construct data
            String data = "";
            /*
             * Note the suggested encoding for certain parameters, notably
             * the username, password and especially the message.  ISO-8859-1
             * is essentially the character set that we use for message bodies,
             * with a few exceptions for e.g. Greek characters.  For a full list,
             * see:  http://developer.bulksms.com/eapi/submission/character-encoding/
             */
            data += "un=" + URLEncoder.encode(username, "ISO-8859-1");   //add username here
            data += "&pwd=" + URLEncoder.encode(password, "ISO-8859-1"); //add pw here
            data += "&dstno=" + URLEncoder.encode(mobileTest, "ISO-8859-1");
            data += "&msg=" + URLEncoder.encode("A customer has just booked an appointment on: " + apptDateTime + "%0aCustomer Name: "+ custName + "%0aService Description: " + servDesc,"ISO-8859-1");
            data += uniqueLink;
            data += "&type=1";
            data += "&sendid="+senderId;

            // Send data
            // Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
            URL url = new URL("http://isms.com.my/isms_send.php");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }

    //note that this is for workshop to receive NOT DONE 
    public void smsForAcceptFinal(String custName, String mobileNo, String vNum){
        try {
            // Construct data
            String data = "";
            /*
             * Note the suggested encoding for certain parameters, notably
             * the username, password and especially the message.  ISO-8859-1
             * is essentially the character set that we use for message bodies,
             * with a few exceptions for e.g. Greek characters.  For a full list,
             * see:  http://developer.bulksms.com/eapi/submission/character-encoding/
             */
            data += "un=" + URLEncoder.encode(username, "ISO-8859-1");   //add username here
            data += "&pwd=" + URLEncoder.encode(password, "ISO-8859-1"); //add pw here
            data += "&dstno=" + URLEncoder.encode(mobileTest, "ISO-8859-1");
            data += "&msg=" + URLEncoder.encode("Your customer, " + custName + " of vehicle number " + vNum + ", has just accepted your final quotation.","ISO-8859-1");
            data += uniqueLink;
            data += "&type=1";
            data += "&sendid="+senderId;

            // Send data
            // Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
            URL url = new URL("http://isms.com.my/isms_send.php");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    //note that this is for workshop to receive NOT DONE 
    public void smsForRejectFinal(String custName, String mobileNo, String vNum){
        try {
            // Construct data
            String data = "";
            /*
             * Note the suggested encoding for certain parameters, notably
             * the username, password and especially the message.  ISO-8859-1
             * is essentially the character set that we use for message bodies,
             * with a few exceptions for e.g. Greek characters.  For a full list,
             * see:  http://developer.bulksms.com/eapi/submission/character-encoding/
             */
            data += "un=" + URLEncoder.encode(username, "ISO-8859-1");   //add username here
            data += "&pwd=" + URLEncoder.encode(password, "ISO-8859-1"); //add pw here
            data += "&dstno=" + URLEncoder.encode(mobileTest, "ISO-8859-1");
            data += "&msg=" + URLEncoder.encode("Your customer, " + custName + " of vehicle number " + vNum + ", has just rejected your final quotation.","ISO-8859-1");
            data += uniqueLink;
            data += "&type=1";
            data += "&sendid="+senderId;

            // Send data
            // Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
            URL url = new URL("http://isms.com.my/isms_send.php");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}
