/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Appointment;
import entity.Offer;
import entity.ValetDriver;
import entity.ValetRequest;
import entity.Vehicle;
import entity.Workshop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author User
 */
public class AppointmentDAO {

    private final String USER_AGENT = "Mozilla/5.0";

    public ArrayList<Appointment> getAppointments(int user_id, String token) throws UnsupportedEncodingException, IOException, ParseException {
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        String url = "http://119.81.43.85/erp/schedule/get_appointment_by_user_id";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        String str = result.toString();
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(str);
        JsonObject jobj = element.getAsJsonObject();
        JsonArray arr = jobj.getAsJsonObject("payload").getAsJsonArray("schedule");
        int arrSize = arr.size();
//        if (arrSize > 20) {
//            arrSize = 20;
//        }
        for (int i = 0; i < arrSize; i++) {
//        for (int i = 0; i < arr.size(); i++) {
            JsonElement ele = arr.get(i);
            JsonObject obj = ele.getAsJsonObject();
            JsonElement attElement = obj.get("schedule_id");
            int id = 0;
            if (!attElement.isJsonNull()) {
                id = attElement.getAsInt();
            }
            attElement = obj.get("shop_id");
            int shopId = 0;
            if (!attElement.isJsonNull()) {
                shopId = attElement.getAsInt();
            }
            attElement = obj.get("appointment_start_time");
            Timestamp appointmentStart = null;
            String dateTimeString = "1990-01-01 00:00:00";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(dateTimeString);
            appointmentStart = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                appointmentStart = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("appointment_end_time");
            Timestamp appointmentEnd = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            appointmentEnd = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                appointmentEnd = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("appointment_title");
            String appointmentTitle = "";
            if (!attElement.isJsonNull()) {
                appointmentTitle = attElement.getAsString();
            }

            attElement = obj.get("request1_id");
            int valetOneId = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneId = attElement.getAsInt();
            }

            attElement = obj.get("request1_service_type");
            int valetOneServiceType = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneServiceType = attElement.getAsInt();
            }

            attElement = obj.get("request1_pick_up_address");
            String valetOnePickUpAddress = "";
            if (attElement != null && !attElement.isJsonNull()) {
                valetOnePickUpAddress = attElement.getAsString();
            }

            attElement = obj.get("request1_pick_up_latitude");
            double valetOnePickUpLat = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOnePickUpLat = attElement.getAsDouble();
            }

            attElement = obj.get("request1_pick_up_longitude");
            double valetOnePickUpLong = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOnePickUpLong = attElement.getAsDouble();
            }

            attElement = obj.get("request1_drop_off_address");
            String valetOneDropOffAddress = "";
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneDropOffAddress = attElement.getAsString();
            }

            attElement = obj.get("request1_drop_off_latitude");
            double valetOneDropOffLat = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneDropOffLat = attElement.getAsDouble();
            }

            attElement = obj.get("request1_drop_off_longitude");
            double valetOneDropOffLong = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneDropOffLong = attElement.getAsDouble();
            }

            attElement = obj.get("request1_scheduled_pick_up_time");
            Timestamp valetOneScheduledPickUpTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetOneScheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetOneScheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request1_actual_pick_up_time");
            Timestamp valetOneActualPickUpTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetOneActualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetOneActualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request1_completed_time");
            Timestamp valetOneCompletedTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetOneCompletedTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetOneCompletedTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request1_status");
            int valetOneStatus = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneStatus = attElement.getAsInt();
            }

            attElement = obj.get("request1_offer_id");
            int valetOneOfferId = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOneOfferId = attElement.getAsInt();
            }

            attElement = obj.get("request1_price");
            int valetOnePrice = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetOnePrice = attElement.getAsInt();
            }

            attElement = obj.get("request2_id");
            int valetTwoId = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoId = attElement.getAsInt();
            }

            attElement = obj.get("request2_service_type");
            int valetTwoServiceType = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoServiceType = attElement.getAsInt();
            }

            attElement = obj.get("request2_pick_up_address");
            String valetTwoPickUpAddress = "";
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoPickUpAddress = attElement.getAsString();
            }

            attElement = obj.get("request2_pick_up_latitude");
            double valetTwoPickUpLat = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoPickUpLat = attElement.getAsDouble();
            }

            attElement = obj.get("request2_pick_up_longitude");
            double valetTwoPickUpLong = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoPickUpLong = attElement.getAsDouble();
            }

            attElement = obj.get("request2_drop_off_address");
            String valetTwoDropOffAddress = "";
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoDropOffAddress = attElement.getAsString();
            }

            attElement = obj.get("request2_drop_off_longitude");
            double valetTwoDropOffLat = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoDropOffLat = attElement.getAsDouble();
            }

            attElement = obj.get("request2_drop_off_longitude");
            double valetTwoDropOffLong = 0.0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoDropOffLong = attElement.getAsDouble();
            }

            attElement = obj.get("request2_scheduled_pick_up_time");
            Timestamp valetTwoScheduledPickUpTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetTwoScheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetTwoScheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request2_actual_pick_up_time");
            Timestamp valetTwoActualPickUpTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetTwoActualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetTwoActualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request2_completed_time");
            Timestamp valetTwoCompletedTime = null;
            dateTimeString = "1990-01-01 00:00:00";
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            valetTwoCompletedTime = new java.sql.Timestamp(parsedDate.getTime());
            if (attElement != null && !attElement.isJsonNull()) {
                dateTimeString = attElement.getAsString();
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                parsedDate = dateFormat.parse(dateTimeString);
                valetTwoCompletedTime = new java.sql.Timestamp(parsedDate.getTime());
            }

            attElement = obj.get("request2_status");
            int valetTwoStatus = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoStatus = attElement.getAsInt();
            }

            attElement = obj.get("request2_offer_id");
            int valetTwoOfferId = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoOfferId = attElement.getAsInt();
            }

            attElement = obj.get("request2_price");
            int valetTwoPrice = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                valetTwoPrice = attElement.getAsInt();
            }

            attElement = obj.get("vehicle_id");
            int vehicleId = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                vehicleId = attElement.getAsInt();
            }

            attElement = obj.get("car_make");
            String carMake = "";
            if (attElement != null && !attElement.isJsonNull()) {
                carMake = attElement.getAsString();
            }

            attElement = obj.get("car_model");
            String carModel = "";
            if (attElement != null && !attElement.isJsonNull()) {
                carModel = attElement.getAsString();
            }

            attElement = obj.get("car_year_manufactured");
            int carYear = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                carYear = attElement.getAsInt();
            }

            attElement = obj.get("car_plate_number");
            String carPlate = "";
            if (attElement != null && !attElement.isJsonNull()) {
                carPlate = attElement.getAsString();
            }

            attElement = obj.get("car_color");
            String carColor = "";
            if (attElement != null && !attElement.isJsonNull()) {
                carColor = attElement.getAsString();
            }

            attElement = obj.get("car_type_of_control_of_car");
            String carControl = "";
            if (attElement != null && !attElement.isJsonNull()) {
                carControl = attElement.getAsString();
            }

            attElement = obj.get("shop_name");
            String shopName = "";
            if (attElement != null && !attElement.isJsonNull()) {
                shopName = attElement.getAsString();
            }
            
            attElement = obj.get("offer_status");
            int offerStatus = 0;
            if (attElement != null && !attElement.isJsonNull()) {
                offerStatus = attElement.getAsInt();
            }

            Vehicle vehicle = new Vehicle(vehicleId, carMake, carModel, carYear, carPlate, carColor, carControl);
            ValetRequest toValet = null;
            Appointment appointment = null;
            if (valetOneId == 0) {
                appointment = new Appointment(id, shopId, appointmentStart, appointmentEnd, shopName, offerStatus);
            } else {
                toValet = new ValetRequest(valetOneId, vehicle, valetOnePickUpAddress, valetOnePickUpLat, valetOnePickUpLong, valetOneDropOffAddress,
                        valetOneDropOffLat, valetOneDropOffLong, valetOneScheduledPickUpTime, valetOneActualPickUpTime, valetOneCompletedTime, valetOnePrice, valetOneOfferId, valetOneStatus);

                if (valetTwoId != 0) {
                    ValetRequest returnValet = new ValetRequest(valetTwoId, vehicle, valetTwoPickUpAddress, valetTwoPickUpLat, valetTwoPickUpLong, valetTwoDropOffAddress,
                            valetTwoDropOffLat, valetTwoDropOffLong, valetTwoScheduledPickUpTime, valetTwoActualPickUpTime, valetTwoCompletedTime, valetTwoPrice, valetTwoOfferId, valetTwoStatus);
                    appointment = new Appointment(id, shopId, appointmentStart, appointmentEnd, toValet, returnValet, shopName,offerStatus);
                } else {
                    appointment = new Appointment(id, shopId, appointmentStart, appointmentEnd, toValet, shopName, offerStatus);
                }
                if (appointment.getReturnValet() != null) {
                }
            }
            appointments.add(appointment);
        }
        return appointments;
    }

    public String addAppointment(int user_id, String token, int shop_id, String title, String start_time, String end_time, int offer_id) throws UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/erp/schedule/add_schedule";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("shop_id", shop_id + ""));
        urlParameters.add(new BasicNameValuePair("start_time", start_time));
        urlParameters.add(new BasicNameValuePair("end_time", end_time));
        urlParameters.add(new BasicNameValuePair("title", title));
        urlParameters.add(new BasicNameValuePair("all_day", 0 + ""));
        urlParameters.add(new BasicNameValuePair("bg_color", "#731F1F"));
        urlParameters.add(new BasicNameValuePair("font_color", "#FFFFFF"));
        urlParameters.add(new BasicNameValuePair("offer_id", offer_id + ""));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        String str = result.toString();
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(str);
        JsonObject jobj = element.getAsJsonObject();
        JsonElement errMsgEle = jobj.get("error_message");
        String errMsg = "";
        if (errMsgEle != null && !errMsgEle.isJsonNull()) {
            errMsg = errMsgEle.getAsString();
        }
        return errMsg;
    }

    public Timestamp calculatePickUpTime(String pickUpAddress, String dropOffAddress, Timestamp appointmentTime) throws UnsupportedEncodingException, IOException {

//        String dropOffPostal = dropOffAddress.substring(dropOffAddress.lastIndexOf(" "));
        String address = pickUpAddress.substring(0, pickUpAddress.lastIndexOf(" "));
        String postal = "Singapore(" + pickUpAddress.substring(pickUpAddress.lastIndexOf(" ") + 1) + ")";
        String fullAddress = address + "," + postal;
        String wsAddress = dropOffAddress.substring(0, dropOffAddress.lastIndexOf(" "));
        String wsPostal = "Singapore(" + dropOffAddress.substring(dropOffAddress.lastIndexOf(" ") + 1) + ")";
        String wsFullAddress = wsAddress + "," + wsPostal;
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                + fullAddress.replace(" ", "+")
                + "&destinations="
                + wsFullAddress.replace(" ", "+")
                + "&key=AIzaSyCpdZ3c3twyc93Rv1PL_E6eOvsnUlP3lqg";

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);

        // add header
        //get.setHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(get);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        String str = result.toString();
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(str);
        JsonObject jobj = element.getAsJsonObject();
        JsonElement oElement = jobj.get("rows");
        if (oElement.isJsonNull()) {
            return null;
        }
        JsonArray arr = oElement.getAsJsonArray();
        JsonObject obj = arr.get(0).getAsJsonObject();
        JsonObject e2 = obj.get("elements").getAsJsonArray().get(0).getAsJsonObject().get("duration").getAsJsonObject();
        JsonElement attElement = e2.get("value");
        //In seconds
        int timeTaken = 0;
        if (!attElement.isJsonNull()) {
            timeTaken = attElement.getAsInt();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(appointmentTime.getTime());

        //Subtract the time taken to reach the drop off point from the appointment time
        cal.add(Calendar.MINUTE, -timeTaken / 60 - 30);

        //Round down the time to the nearest 15 minute
        int unroundedMinutes = cal.get(Calendar.MINUTE);
        int mod = unroundedMinutes % 10;
        cal.set(Calendar.MINUTE, unroundedMinutes - mod);

        Timestamp later = new Timestamp(cal.getTime().getTime());
        return later;
    }

    public Appointment getAppointmentById(int user_id, String token, int schedule_id) throws UnsupportedEncodingException, IOException, ParseException {
        Appointment appointment = null;
        String url = "http://119.81.43.85/erp/schedule/get_appointment_by_id";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("schedule_id", schedule_id + ""));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        String str = result.toString();
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse(str);
        JsonObject jobj = element.getAsJsonObject();
        JsonElement oElement = jobj.get("payload");
        JsonObject oObj = null;
        if (oElement.isJsonNull()) {
            return appointment;
        }
        
        oObj = oElement.getAsJsonObject().getAsJsonObject("schedule");
        JsonElement attElement = oObj.get("schedule_id");
        int scheduleId = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            scheduleId = attElement.getAsInt();
        }

        attElement = oObj.get("appointment_start_time");
        Timestamp appointmentStartTime = null;
        String dateTimeString = "1990-01-01 00:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = dateFormat.parse(dateTimeString);
        appointmentStartTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            appointmentStartTime = new java.sql.Timestamp(parsedDate.getTime());
        }
        
        attElement = oObj.get("appointment_end_time");
        Timestamp appointmentEndTime = null;
        dateTimeString = "1990-01-01 00:00:00";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        parsedDate = dateFormat.parse(dateTimeString);
        appointmentEndTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            appointmentEndTime = new java.sql.Timestamp(parsedDate.getTime());
        }
        
        attElement = oObj.get("appointment_title");
        String appointmentTitle = "";
        if (attElement != null && !attElement.isJsonNull()) {
            appointmentTitle = attElement.getAsString();
        }

        attElement = oObj.get("request_id");
        int valetRequestId = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            valetRequestId = attElement.getAsInt();
        }

        attElement = oObj.get("pick_up_address");
        String pickUpAddress = "";
        if (attElement != null && !attElement.isJsonNull()) {
            pickUpAddress = attElement.getAsString();
        }

        attElement = oObj.get("pick_up_longitude");
        double pickUpLongitude = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            pickUpLongitude = attElement.getAsDouble();
        }

        attElement = oObj.get("pick_up_latitude");
        double pickUpLatitude = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            pickUpLatitude = attElement.getAsDouble();
        }

        attElement = oObj.get("drop_off_address");
        String dropOffAddress = "";
        if (attElement != null && !attElement.isJsonNull()) {
            dropOffAddress = attElement.getAsString();
        }
        attElement = oObj.get("drop_off_latitude");
        double dropOffLongitude = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            dropOffLongitude = attElement.getAsDouble();
        }

        attElement = oObj.get("drop_off_longitude");
        double dropOffLatitude = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            dropOffLatitude = attElement.getAsDouble();
        }

        attElement = oObj.get("scheduled_pick_up_time");
        Timestamp scheduledPickUpTime = null;
        dateTimeString = "1990-01-01 00:00:00";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        parsedDate = dateFormat.parse(dateTimeString);
        scheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            scheduledPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
        }

        attElement = oObj.get("actual_pick_up_time");
        Timestamp actualPickUpTime = null;
        dateTimeString = "1990-01-01 00:00:00";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        parsedDate = dateFormat.parse(dateTimeString);
        actualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            actualPickUpTime = new java.sql.Timestamp(parsedDate.getTime());
        }

        attElement = oObj.get("completed_time");
        Timestamp completedTime = null;
        dateTimeString = "1990-01-01 00:00:00";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        parsedDate = dateFormat.parse(dateTimeString);
        completedTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            completedTime = new java.sql.Timestamp(parsedDate.getTime());
        }

        attElement = oObj.get("request_status");
        int valetRequestStatus = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            valetRequestStatus = attElement.getAsInt();
        }

        attElement = oObj.get("price");
        double valetPrice = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            valetPrice = attElement.getAsDouble();
        }

        attElement = oObj.get("offer_id");
        int offerId = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            offerId = attElement.getAsInt();
        }
        
        attElement = oObj.get("valet_driver_id");
        int valetDriverId = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            valetDriverId = attElement.getAsInt();
        }
        
        attElement = oObj.get("valet_driver_name");
        String valetDriverName = "";
        if (attElement != null && !attElement.isJsonNull()) {
            valetDriverName = attElement.getAsString();
        }
        
        attElement = oObj.get("valet_driver_email");
        String valetDriverEmail = "";
        if (attElement != null && !attElement.isJsonNull()) {
            valetDriverEmail = attElement.getAsString();
        }
        
        attElement = oObj.get("valet_driver_handphone");
        String valetDriverHandphone = "";
        if (attElement != null && !attElement.isJsonNull()) {
            valetDriverHandphone = attElement.getAsString();
        }
        
        attElement = oObj.get("valet_driver_profile_picture");
        String valetPicture = "";
        if (attElement != null && !attElement.isJsonNull()) {
            valetPicture = attElement.getAsString();
        }
        
        attElement = oObj.get("workshop_id");
        int workshopId = 0;
        if (attElement != null && !attElement.isJsonNull()) {
            workshopId = attElement.getAsInt();
        }
        
        attElement = oObj.get("workshop_name");
        String workshopName = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopName = attElement.getAsString();
        }
        
        attElement = oObj.get("workshop_opening_hours");
        String workshopOpeningHours = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopOpeningHours = attElement.getAsString();
        }
        
        attElement = oObj.get("workshop_address");
        String workshopAddress = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopAddress = attElement.getAsString();
        }
        
        attElement = oObj.get("workshop_category");
        String workshopCategory = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopCategory = attElement.getAsString();
        }

        attElement = oObj.get("workshop_other_brands");
        String workshopBrandsCarried = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopBrandsCarried = attElement.getAsString();
        }

        attElement = oObj.get("workshop_website");
        String workshopWebsite = "";
        if (attElement != null && !attElement.isJsonNull()) {
            workshopWebsite = attElement.getAsString();
        }

        attElement = oObj.get("est_complete_time");
        Timestamp estCompletionDateTime = null;
        dateTimeString = "1990-01-01 00:00:00";
        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        parsedDate = dateFormat.parse(dateTimeString);
        estCompletionDateTime = new java.sql.Timestamp(parsedDate.getTime());
        if (attElement != null && !attElement.isJsonNull()) {
            dateTimeString = attElement.getAsString();
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            parsedDate = dateFormat.parse(dateTimeString);
            estCompletionDateTime = new java.sql.Timestamp(parsedDate.getTime());
        }

        attElement = oObj.get("final_price");
        double finalPrice = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            finalPrice = attElement.getAsDouble();
        }
        
        ValetRequest vr = new ValetRequest(valetRequestId, pickUpAddress, pickUpLatitude, pickUpLongitude, dropOffAddress, dropOffLatitude, dropOffLongitude, scheduledPickUpTime, actualPickUpTime, completedTime, valetPrice, offerId, valetRequestStatus);
        ValetDriver vd = new ValetDriver(valetDriverId, valetDriverEmail, valetDriverName, valetDriverHandphone, valetPicture);
        Workshop ws = new Workshop(workshopId, workshopName, workshopOpeningHours, workshopAddress, workshopCategory, workshopBrandsCarried, workshopWebsite);
        appointment = new Appointment(scheduleId, appointmentStartTime, appointmentEndTime, appointmentTitle, vr, vd, ws, finalPrice, estCompletionDateTime);
        return appointment;

    }
     
    public static void main(String[] args) throws ParseException, IOException {
        //getAppointments(374, "edd0b70bd3849edf63c21ffb8d5ed78ef4565bbcffacea8b7a0ee03f2da96063f031cc7d9261baf0138dc0936fae17a8d176cbb7504939aef107c92a403ab6eb9c9c5a0184fb63fab863d48e7ea0b67678e4915b2496bfc742b4883f98a1ebde445f05266ee4517f5a29c3a2e473f4b7fc4537cd74a9eabd293a9126c0d36b85bdf6bd9bd3931ae225ca038f249ba44871cc53e885f6819756f07bde58d65af3cd72c1e2f3a666775a9775e805852deb3c49e750eefeea7814fb05a64b9bf82797a615744725bc146dd5ce58f9940d78f3a457cefaf6867ee485132dc077a870e3c672c7efd18fb635e5eed398e5df28f9383032b16e717f04345fc04b42a2840abf67d661096b6977de90dcc8d1f3e03087f1ccee98f21d2c2cb39b21b72482b757e13447d2951d3d519dcf677e531b187da6e907e8682c67981cce5ac56a757cd0354043b4207c986993e3115dfdeeb9d821addceeea8f4dba57dbf56e5a7c04a82836b4880067a82da742d176729cf257a81348a227b4dddc991584dc2b5034a33462fffc0307b43b7730ad76c5a45758544599662db7562ede00fd609602f7cf9ea13bcf2f159346076b20a45cf236b100b0e3ea483fde8b3391026dbc0f87bdd2572feae9b581f05b2641bc37b727382fc50cd76330215e69227d555730bd89a8b467b47e99c8221f0d5d483021b75327a9edc138a265256a13628de2fe");
        //addAppointment(374, "edd0b70bd3849edf63c21ffb8d5ed78ef4565bbcffacea8b7a0ee03f2da96063f031cc7d9261baf0138dc0936fae17a8d176cbb7504939aef107c92a403ab6eb9c9c5a0184fb63fab863d48e7ea0b67678e4915b2496bfc742b4883f98a1ebde445f05266ee4517f5a29c3a2e473f4b7fc4537cd74a9eabd293a9126c0d36b85bdf6bd9bd3931ae225ca038f249ba44871cc53e885f6819756f07bde58d65af3cd72c1e2f3a666775a9775e805852deb3c49e750eefeea7814fb05a64b9bf82797a615744725bc146dd5ce58f9940d78f3a457cefaf6867ee485132dc077a870e3c672c7efd18fb635e5eed398e5df28f9383032b16e717f04345fc04b42a2840abf67d661096b6977de90dcc8d1f3e03087f1ccee98f21d2c2cb39b21b72482b757e13447d2951d3d519dcf677e531b187da6e907e8682c67981cce5ac56a757cd0354043b4207c986993e3115dfdeeb9d821addceeea8f4dba57dbf56e5a7c04a82836b4880067a82da742d176729cf257a81348a227b4dddc991584dc2b5034a33462fffc0307b43b7730ad76c5a45758544599662db7562ede00fd609602f7cf9ea13bcf2f159346076b20a45cf236b100b0e3ea483fde8b3391026dbc0f87bdd2572feae9b581f05b2641bc37b727382fc50cd76330215e69227d555730bd89a8b467b47e99c8221f0d5d483021b75327a9edc138a265256a13628de2fe", 1, "Test", "2016-12-16 15:00:00", "2016-12-16 15:00:00", 2);
        //getAppointmentByOfferId(374, "edd0b70bd3849edf63c21ffb8d5ed78ef4565bbcffacea8b7a0ee03f2da96063f031cc7d9261baf0138dc0936fae17a8d176cbb7504939aef107c92a403ab6eb9c9c5a0184fb63fab863d48e7ea0b67678e4915b2496bfc742b4883f98a1ebde445f05266ee4517f5a29c3a2e473f4b7fc4537cd74a9eabd293a9126c0d36b85bdf6bd9bd3931ae225ca038f249ba44871cc53e885f6819756f07bde58d65af3cd72c1e2f3a666775a9775e805852deb3c49e750eefeea7814fb05a64b9bf82797a615744725bc146dd5ce58f9940d78f3a457cefaf6867ee485132dc077a870e3c672c7efd18fb635e5eed398e5df28f9383032b16e717f04345fc04b42a2840abf67d661096b6977de90dcc8d1f3e03087f1ccee98f21d2c2cb39b21b72482b757e13447d2951d3d519dcf677e531b187da6e907e8682c67981cce5ac56a757cd0354043b4207c986993e3115dfdeeb9d821addceeea8f4dba57dbf56e5a7c04a82836b4880067a82da742d176729cf257a81348a227b4dddc991584dc2b5034a33462fffc0307b43b7730ad76c5a45758544599662db7562ede00fd609602f7cf9ea13bcf2f159346076b20a45cf236b100b0e3ea483fde8b3391026dbc0f87bdd2572feae9b581f05b2641bc37b727382fc50cd76330215e69227d555730bd89a8b467b47e99c8221f0d5d483021b75327a9edc138a265256a13628de2fe", 20);
    }

}
