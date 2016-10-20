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
import entity.Driver;
import entity.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author User
 */
public class DriverDAO {

    private final String USER_AGENT = "Mozilla/5.0";

    public ArrayList<String> addDriver(String name, String email, String password, String handphone) throws UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/user/signup";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("password", password));
        urlParameters.add(new BasicNameValuePair("email", email));
        urlParameters.add(new BasicNameValuePair("handphone", handphone));

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
        String errorMessage = null;
        ArrayList<String> errors = new ArrayList<String>();
        JsonElement isSuccess = jobj.get("is_success");
        if (isSuccess.getAsString().equals("false")) {
            errorMessage = jobj.get("error_message").getAsString();
            errors.add(errorMessage);
            JsonElement fields = jobj.get("payload");
            if (!fields.isJsonNull()) {
                JsonArray arr = fields.getAsJsonObject().get("error_field").getAsJsonArray();
                for (int i = 0; i < arr.size(); i++) {
                    String f = arr.get(i).getAsString();
                    errors.add(f);
                }
            }
        }

        return errors;

    }

    public Driver authenticateUser(String loginEmail, String password) throws UnsupportedEncodingException, IOException {

        Driver driver = null;
        String url = "http://119.81.43.85/user/login";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("username", loginEmail));
        urlParameters.add(new BasicNameValuePair("password", password));

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
        JsonElement isSuccess = jobj.get("is_success");
        if (isSuccess.getAsString().equals("false")) {
            return driver;
        } else {
            JsonElement payload = jobj.get("payload");
            JsonObject userObj = payload.getAsJsonObject();
            JsonElement attElement = userObj.get("userData");
            JsonObject user = attElement.getAsJsonObject();
            attElement = user.get("id");
            int id = 0;
            if (!attElement.isJsonNull()) {
                id = attElement.getAsInt();
            }

            String name = "";
            attElement = user.get("name");
            if (attElement != null && !attElement.isJsonNull()) {
                name = attElement.getAsString();
            }

            String email = "";
            attElement = user.get("email");
            if (attElement != null && !attElement.isJsonNull()) {
                email = attElement.getAsString();
            }
            String handphone = "";
            attElement = user.get("handphone");
            if (attElement != null && !attElement.isJsonNull()) {
                handphone = attElement.getAsString();
            }

            String token = "";
            attElement = user.get("token");
            if (attElement != null && !attElement.isJsonNull()) {
                token = attElement.getAsString();
            }
            ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
            JsonArray arr = (JsonArray) userObj.get("vehicleData");
            int arrSize = arr.size();
            for (int i = 0; i < arrSize; i++) {
//        for (int i = 0; i < arr.size(); i++) {
                JsonElement qrElement = arr.get(i);
                JsonObject qrObj = qrElement.getAsJsonObject();
                attElement = qrObj.get("id");
                int vid = 0;
                if (!attElement.isJsonNull()) {
                    vid = attElement.getAsInt();
                }
                attElement = qrObj.get("make");
                String make = "";
                if (!attElement.isJsonNull()) {
                    make = attElement.getAsString();
                }
                attElement = qrObj.get("model");
                String model = "";
                if (!attElement.isJsonNull()) {
                    model = attElement.getAsString();
                }
                attElement = qrObj.get("year");
                int year = 0;
                if (!attElement.isJsonNull()) {
                    year = attElement.getAsInt();
                }
                attElement = qrObj.get("plate_number");
                String plate_number = "";
                if (!attElement.isJsonNull()) {
                    plate_number = attElement.getAsString();
                }
                attElement = qrObj.get("user_id");
                int user_id = 0;
                if (!attElement.isJsonNull()) {
                    user_id = attElement.getAsInt();
                }

                attElement = qrObj.get("car_color");
                String car_color = "";
                if (!attElement.isJsonNull()) {
                    car_color = attElement.getAsString();
                }

                attElement = qrObj.get("type_of_control_of_car");
                String control = "";
                if (!attElement.isJsonNull()) {
                    control = attElement.getAsString();
                }
                Vehicle vehicle = new Vehicle(vid, make, model, year, plate_number, user_id, car_color, control);
                vList.add(vehicle);
            }

            driver = new Driver(id, name, email, password, handphone, token, vList);
        }
        return driver;
    }
    
    public String updateDriver(int user_id, String token, String nName, String nMobile) throws UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/user/edit_profile";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("nName", nName));
        urlParameters.add(new BasicNameValuePair("nMobile", nMobile));

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

    public boolean updateUserPassword(int user_id, String token, String currentPassword, String newPassword) throws UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/user/change_password";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("currentPassword", currentPassword));
        urlParameters.add(new BasicNameValuePair("nPassword", newPassword));

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
        JsonElement isSuccess = jobj.get("is_success");
        if (isSuccess.getAsString().equals("false")) {
            return false;
        } else {
            return true;
        }
    }
    
    public static void main(String[] args) throws IOException {
        //authenticateUser("james@james.com", "12345678");
    }
}
