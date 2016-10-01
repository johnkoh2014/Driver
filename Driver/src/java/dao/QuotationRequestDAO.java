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
import entity.Offer;
import entity.QuotationRequest;
import entity.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.apache.http.HttpHeaders.USER_AGENT;
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
public class QuotationRequestDAO {

    public ArrayList<QuotationRequest> getAllRequests(int user_id, String token) throws UnsupportedEncodingException, IOException, ParseException {

        ArrayList<QuotationRequest> qList = new ArrayList<QuotationRequest>();
        ArrayList<Offer> offerList = new ArrayList<Offer>();
        String url = "http://119.81.43.85/service/get_services";

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
        JsonElement isSuccess = jobj.get("is_success");
        if (isSuccess.getAsString().equals("false")) {
            return qList;
        } else {
            JsonArray arr = jobj.getAsJsonObject("payload").getAsJsonArray("serviceData");
            for (int i = 0; i < arr.size(); i++) {
                JsonElement qrElement = arr.get(i);
                JsonObject qrObj = qrElement.getAsJsonObject();
                JsonElement attElement = qrObj.get("id");
                int id = 0;
                if (!attElement.isJsonNull()) {
                    id = attElement.getAsInt();
                }
                attElement = qrObj.get("name");
                String name = "";
                if (!attElement.isJsonNull()) {
                    name = attElement.getAsString();
                }
                attElement = qrObj.get("details");
                String details = "";
                if (!attElement.isJsonNull()) {
                    details = attElement.getAsString();
                }
                attElement = qrObj.get("vehicle_id");
                int vehicle_id = 0;
                if (!attElement.isJsonNull()) {
                    vehicle_id = attElement.getAsInt();
                }

                attElement = qrObj.get("mileage");
                String mileage = "";
                if (!attElement.isJsonNull()) {
                    mileage = attElement.getAsString();
                }
                attElement = qrObj.get("urgency");
                String urgency = "";
                if (!attElement.isJsonNull()) {
                    urgency = attElement.getAsString();
                }

                attElement = qrObj.get("amenities");
                String amenities = "";
                if (!attElement.isJsonNull()) {
                    amenities = attElement.getAsString();
                }

                attElement = qrObj.get("longitude");
                double longitude = 0.0;
                if (!attElement.isJsonNull()) {
                    longitude = attElement.getAsDouble();
                }

                attElement = qrObj.get("latitude");
                double latitude = 0.0;
                if (!attElement.isJsonNull()) {
                    latitude = attElement.getAsDouble();
                }

                attElement = qrObj.get("address");
                String address = "";
                if (!attElement.isJsonNull()) {
                    address = attElement.getAsString();
                }

                attElement = qrObj.get("photos");
                String photos = "";
                if (!attElement.isJsonNull()) {
                    photos = attElement.getAsString();
                }

                attElement = qrObj.get("read");
                int read = 0;
                if (!attElement.isJsonNull()) {
                    read = attElement.getAsInt();
                }

                attElement = qrObj.get("delete");
                int delete = 0;
                if (!attElement.isJsonNull()) {
                    delete = attElement.getAsInt();
                }

                attElement = qrObj.get("category");
                String category = "";
                if (!attElement.isJsonNull()) {
                    category = attElement.getAsString();
                }

                attElement = qrObj.get("rejection_times");
                int rejection_times = 0;
                if (!attElement.isJsonNull()) {
                    rejection_times = attElement.getAsInt();
                }

                attElement = qrObj.get("no_of_offers");
                int no_of_offers = 0;
                if (!attElement.isJsonNull()) {
                    no_of_offers = attElement.getAsInt();
                }

                attElement = qrObj.get("created");
                Timestamp estCompletionDateTime = null;
                String dateTimeString = "1990-01-01 00:00:00";
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date parsedDate = dateFormat.parse(dateTimeString);
                estCompletionDateTime = new java.sql.Timestamp(parsedDate.getTime());
                if (attElement != null && !attElement.isJsonNull()) {
                    dateTimeString = attElement.getAsString();
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    parsedDate = dateFormat.parse(dateTimeString);
                    estCompletionDateTime = new java.sql.Timestamp(parsedDate.getTime());
                }

                JsonArray offerArr = (JsonArray) qrObj.get("offers");
                for (int j = 0; j < offerArr.size(); j++) {
                    JsonElement offerElement = offerArr.get(j);
                    JsonObject offerObj = offerElement.getAsJsonObject();
                    attElement = offerObj.get("status");
                    int status = 0;
                    if (!attElement.isJsonNull()) {
                        status = attElement.getAsInt();
                    }

                    attElement = offerObj.get("min_price");
                    double min_price = 0.0;
                    if (!attElement.isJsonNull()) {
                        min_price = attElement.getAsInt();
                    }

                    attElement = offerObj.get("final_price");
                    double final_price = 0.0;
                    if (!attElement.isJsonNull()) {
                        final_price = attElement.getAsInt();
                    }

                    attElement = offerObj.get("max_price");
                    double max_price = 0.0;
                    if (!attElement.isJsonNull()) {
                        max_price = attElement.getAsInt();
                    }

                    attElement = offerObj.get("diagnostic_price");
                    double diagnostic_price = 0.0;
                    if (!attElement.isJsonNull()) {
                        diagnostic_price = attElement.getAsInt();
                    }

                    attElement = offerObj.get("offer_id");
                    int offer_id = 0;
                    if (!attElement.isJsonNull()) {
                        offer_id = attElement.getAsInt();
                    }

                    attElement = offerObj.get("shop_id");
                    int shop_id = 0;
                    if (!attElement.isJsonNull()) {
                        shop_id = attElement.getAsInt();
                    }

                    attElement = offerObj.get("shop_name");
                    String shop_name = "";
                    if (!attElement.isJsonNull()) {
                        shop_name = attElement.getAsString();
                    }

                    attElement = offerObj.get("contact1");
                    String contact1 = "";
                    if (!attElement.isJsonNull()) {
                        contact1 = attElement.getAsString();
                    }

                    attElement = offerObj.get("contact2");
                    String contact2 = "";
                    if (!attElement.isJsonNull()) {
                        contact2 = attElement.getAsString();
                    }
                    Offer offer = new Offer(offer_id, id, final_price, shop_id, shop_name, contact1, contact2, status, min_price, max_price, diagnostic_price);
                    offerList.add(offer);

                }

                QuotationRequest qr = new QuotationRequest(id, name, details, mileage, urgency, amenities, latitude, longitude, address, estCompletionDateTime,
                        category, rejection_times, no_of_offers, read, vehicle_id, offerList);
                qList.add(qr);
            }
            return qList;
        }
    }
    
    public ArrayList<String> addRequest(int user_id, String token,int vehicle_id, String service, String type, String description, String mileage) throws UnsupportedEncodingException, IOException {

        String url = "http://119.81.43.85/service/save_services";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("vehicle_id", vehicle_id + ""));
        urlParameters.add(new BasicNameValuePair("mileage", mileage));
        urlParameters.add(new BasicNameValuePair("latitude", "0.0"));
        urlParameters.add(new BasicNameValuePair("longitude", "0.0"));
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("services[0][name]", service + " - " + type));
        urlParameters.add(new BasicNameValuePair("services[0][details]", ""));
        urlParameters.add(new BasicNameValuePair("services[0][description]", description));

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

}
