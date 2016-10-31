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
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;

/**
 *
 * @author User
 */
public class OfferDAO {

    public ArrayList<Offer> getOffers(int user_id, String token, int qrId) throws UnsupportedEncodingException, IOException, ParseException {

        ArrayList<Offer> offerList = new ArrayList<Offer>();
        String url = "http://119.81.43.85/offer/get_offer";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("id", qrId + ""));

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
            return offerList;
        } else {
            JsonArray arr = jobj.getAsJsonArray("payload");
            for (int i = 0; i < arr.size(); i++) {
                JsonElement qrElement = arr.get(i);
                JsonObject qrObj = qrElement.getAsJsonObject();

                JsonElement attElement = qrObj.get("id");
                int offer_id = 0;
                if (!attElement.isJsonNull()) {
                    offer_id = attElement.getAsInt();
                }
                attElement = qrObj.get("name");
                String name = "";
                if (!attElement.isJsonNull()) {
                    name = attElement.getAsString();
                }
                attElement = qrObj.get("contact");
                String contact = "";
                if (!attElement.isJsonNull()) {
                    contact = attElement.getAsString();
                }

                attElement = qrObj.get("shop_id");
                int shop_id = 0;
                if (!attElement.isJsonNull()) {
                    shop_id = attElement.getAsInt();
                }

                attElement = qrObj.get("final_price");
                double final_price = 0.0;
                if (!attElement.isJsonNull()) {
                    final_price = attElement.getAsDouble();
                }

                attElement = qrObj.get("min_price");
                double min_price = 0.0;
                if (!attElement.isJsonNull()) {
                    min_price = attElement.getAsDouble();
                }

                attElement = qrObj.get("max_price");
                double max_price = 0.0;
                if (!attElement.isJsonNull()) {
                    max_price = attElement.getAsDouble();
                }

                attElement = qrObj.get("diagnostic_price");
                double diagnostic_price = 0.0;
                if (!attElement.isJsonNull()) {
                    diagnostic_price = attElement.getAsDouble();
                }

                attElement = qrObj.get("status");
                int status = 0;
                if (!attElement.isJsonNull()) {
                    status = attElement.getAsInt();
                }
                Offer offer = new Offer(offer_id, name, contact, shop_id, final_price, min_price, max_price, diagnostic_price, status);
                offerList.add(offer);

            }
        }
        return offerList;
    }

    public Offer retrieveOfferById(int user_id, String token, int offerId) throws SQLException, ParseException, UnsupportedEncodingException, IOException {
        Offer offer = null;
        String url = "http://119.81.43.85/quotation_request/retrieve_min_max_quotation_or_diagnostic_price";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("offer_id", offerId + ""));

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
            return offer;
        }

        oObj = oElement.getAsJsonObject();
        JsonElement attElement = oObj.get("service_id");
        int serviceId = 0;
        if (!attElement.isJsonNull()) {
            serviceId = attElement.getAsInt();
        }

        attElement = oObj.get("service_name");
        String serviceName = "";
        if (!attElement.isJsonNull()) {
            serviceName = attElement.getAsString();
        }

        attElement = oObj.get("shop_opening_hours");
        String openingHour = "";
        if (!attElement.isJsonNull()) {
            openingHour = attElement.getAsString();
        }

        attElement = oObj.get("shop_name");
        String shopName = "";
        if (!attElement.isJsonNull()) {
            shopName = attElement.getAsString();
        }

        attElement = oObj.get("shop_address");
        String shopAddress = "";
        if (!attElement.isJsonNull()) {
            shopAddress = attElement.getAsString();
        }

        attElement = oObj.get("shop_category");
        String shopCategory = "";
        if (!attElement.isJsonNull()) {
            shopCategory = attElement.getAsString();
        }

        attElement = oObj.get("shop_brands_carried");
        String brandsCarried = "";
        if (!attElement.isJsonNull()) {
            brandsCarried = attElement.getAsString();
        }

        attElement = oObj.get("shop_website");
        String website = "";
        if (!attElement.isJsonNull()) {
            website = attElement.getAsString();
        }

        attElement = oObj.get("ws_initial_comment");
        String wsInitialComment = "";
        if (!attElement.isJsonNull()) {
            wsInitialComment = attElement.getAsString();
        }

        attElement = oObj.get("ws_final_comment");
        String wsFinalComment = "";
        if (!attElement.isJsonNull()) {
            wsFinalComment = attElement.getAsString();
        }

        attElement = oObj.get("driver_initial_comment");
        String driverInitialComment = "";
        if (!attElement.isJsonNull()) {
            driverInitialComment = attElement.getAsString();
        }

        attElement = oObj.get("est_complete_time");
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

        attElement = oObj.get("final_price");
        double finalPrice = 0.0;
        if (!attElement.isJsonNull()) {
            finalPrice = attElement.getAsDouble();
        }

        attElement = oObj.get("offer_status");
        int status = 0;
        if (!attElement.isJsonNull()) {
            status = attElement.getAsInt();
        }

        attElement = oObj.get("shop_id");
        int wsId = 0;
        if (!attElement.isJsonNull()) {
            wsId = attElement.getAsInt();
        }

        attElement = oObj.get("min_price");
        double initialMinPrice = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            initialMinPrice = attElement.getAsDouble();
        }

        attElement = oObj.get("max_price");
        double initialMaxPrice = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            initialMaxPrice = attElement.getAsDouble();
        }

        attElement = oObj.get("diagnostic_price");
        double diagnosticPrice = 0.0;
        if (attElement != null && !attElement.isJsonNull()) {
            diagnosticPrice = attElement.getAsDouble();
        }

        attElement = oObj.get("vehicle_id");
        int vehicle_id = 0;
        if (!attElement.isJsonNull()) {
            vehicle_id = attElement.getAsInt();
        }

        attElement = oObj.get("car_make");
        String car_make = "";
        if (!attElement.isJsonNull()) {
            car_make = attElement.getAsString();
        }

        attElement = oObj.get("car_model");
        String car_model = "";
        if (!attElement.isJsonNull()) {
            car_model = attElement.getAsString();
        }

        attElement = oObj.get("car_year");
        int car_year = 0;
        if (!attElement.isJsonNull()) {
            car_year = attElement.getAsInt();
        }

        attElement = oObj.get("car_plate_number");
        String car_plate_number = "";
        if (!attElement.isJsonNull()) {
            car_plate_number = attElement.getAsString();
        }

        attElement = oObj.get("car_color");
        String car_color = "";
        if (!attElement.isJsonNull()) {
            car_color = attElement.getAsString();
        }

        attElement = oObj.get("car_control");
        String car_control = "";
        if (!attElement.isJsonNull()) {
            car_control = attElement.getAsString();
        }
        Vehicle vehicle = new Vehicle(vehicle_id, car_make, car_model, car_year, car_plate_number, user_id, car_color, car_control);

        offer = new Offer(offerId, serviceId, serviceName, openingHour, wsId, shopName, shopAddress, shopCategory, brandsCarried, website, status, initialMinPrice, initialMaxPrice, diagnosticPrice, finalPrice, estCompletionDateTime, vehicle, wsInitialComment, wsFinalComment, driverInitialComment);
        return offer; 

    }

    public String acceptOfferWithValet(boolean is_use_valet, int offer_id, int user_id, String token, int shop_id, String start_time,
            String end_time, String title, String pick_up_address, double pick_up_latitude, double pick_up_longitude, String drop_off_address,
            double drop_off_latitude, double drop_off_longitude, String scheduled_pick_up_time, double price, String driver_comment) throws SQLException, ParseException, UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/quotation_request/initial_quotation_accepted";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("is_use_valet", is_use_valet + ""));
        urlParameters.add(new BasicNameValuePair("offer_id", offer_id + ""));
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("shop_id", shop_id + ""));
        urlParameters.add(new BasicNameValuePair("start_time", start_time));
        urlParameters.add(new BasicNameValuePair("end_time", end_time));
        urlParameters.add(new BasicNameValuePair("title", title));
        urlParameters.add(new BasicNameValuePair("bg_color", "#731F1F"));
        urlParameters.add(new BasicNameValuePair("font_color", "#FFF"));
        urlParameters.add(new BasicNameValuePair("service_type", "1"));
        urlParameters.add(new BasicNameValuePair("pick_up_address", pick_up_address));
        urlParameters.add(new BasicNameValuePair("pick_up_latitude", pick_up_latitude + ""));
        urlParameters.add(new BasicNameValuePair("pick_up_longitude", pick_up_longitude + ""));
        urlParameters.add(new BasicNameValuePair("drop_off_address", drop_off_address));
        urlParameters.add(new BasicNameValuePair("drop_off_latitude", drop_off_latitude + ""));
        urlParameters.add(new BasicNameValuePair("drop_off_longitude", drop_off_longitude + ""));
        urlParameters.add(new BasicNameValuePair("scheduled_pick_up_time", scheduled_pick_up_time));
        urlParameters.add(new BasicNameValuePair("price", price + ""));
        urlParameters.add(new BasicNameValuePair("driver_comment", driver_comment));

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

    public String acceptOfferWithoutValet(boolean is_use_valet, int offer_id, int user_id, String token, int shop_id, String start_time,
            String end_time, String title, String driver_comment) throws SQLException, ParseException, UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/quotation_request/initial_quotation_accepted";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("is_use_valet", is_use_valet + ""));
        urlParameters.add(new BasicNameValuePair("offer_id", offer_id + ""));
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("shop_id", shop_id + ""));
        urlParameters.add(new BasicNameValuePair("start_time", start_time));
        urlParameters.add(new BasicNameValuePair("end_time", end_time));
        urlParameters.add(new BasicNameValuePair("title", title));
        urlParameters.add(new BasicNameValuePair("bg_color", "#731F1F"));
        urlParameters.add(new BasicNameValuePair("font_color", "#FFF"));
        urlParameters.add(new BasicNameValuePair("driver_comment", driver_comment));

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

    public String acceptFinalQuotation(int user_id, String token, int offer_id) throws UnsupportedEncodingException, IOException, ParseException {
        String url = "http://119.81.43.85/quotation_request/final_quotation_accepted";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("offer_id", offer_id + ""));
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
        JsonElement errMsgEle = jobj.get("error_message");
        String errMsg = "";
        if (errMsgEle != null && !errMsgEle.isJsonNull()) {
            errMsg = errMsgEle.getAsString();
        }
        return errMsg;
    }

    public String rejectFinalQuotation(int user_id, String token, int offer_id) throws UnsupportedEncodingException, IOException, ParseException {
        String url = "http://119.81.43.85/quotation_request/offer_declined";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("offer_id", offer_id + ""));
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
        JsonElement errMsgEle = jobj.get("error_message");
        String errMsg = "";
        if (errMsgEle != null && !errMsgEle.isJsonNull()) {
            errMsg = errMsgEle.getAsString();
        }
        return errMsg;
    }

    public String confirmValetPayment(int user_id, String token, int request_id) throws UnsupportedEncodingException, IOException, ParseException {
        String url = "http://119.81.43.85/erp/valet_request/confirm_valet_payment";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("request_id", request_id + ""));
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
        JsonElement errMsgEle = jobj.get("error_message");
        String errMsg = "";
        if (errMsgEle != null && !errMsgEle.isJsonNull()) {
            errMsg = errMsgEle.getAsString();
        }
        System.out.println(errMsg);
        return errMsg;
    }
    public String[] retrieveLatLong(String address) throws Exception {
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String) expr.evaluate(document, XPathConstants.STRING);
            if (status.equals("OK")) {
                expr = xpath.compile("//geometry/location/lat");
                String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                return new String[]{latitude, longitude};
            } else {
                return null;
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws IOException, UnsupportedEncodingException, ParseException {
        //confirmValetPayment(409, "5deab3cea69ada808710eec3daf59cff593b3cb10d1d4a57eeef0001554130f76a977c9208b7a60f479c70340dd2569d93701630bb3e08969e8b0a5f324b71f0a78b429f54bbff351fda56a94eb589398cd742f298dd22d203ae2259fecde496bab5a2c12e9e19b086a52d997996b63bd7e49a63bf96214a9c0fc18d758b25f86666e7f44c56644bac5f13c4f8406a52208f7e89f624a2deaa61e8abec136ea47e1e7a7e828a766e4efd8d3ade0dc0854edcfa8023253d121c1845b882bde7ac3d3b1573a77e35d3c447f4ce26198b261a27425b8525ac54cb5d6ce9376e1ca367eafcda81f04b9ba0dc56333c2c187049aa887147a47161a8ed3d531eaca9591d157354bc6566b580f29b08850f2a5c0f7b7da30f28bacdb34c1127289f7f79cda92ad84882b5d070a47d5039502bb22e65ef63fa29a532094a931ec1d2decc3b4ed490a7669ea231c372f1f16a2a8d3d022711275c261ff2571850382000d5f24e1fabc24a2f15522523e40c749f74e4f52700735a79c6851d3dee4a9e20255a5f02493e92f7fba977aef673202f55cc6ef27dcac30a3a74bde3d3e23431ec119e74c3ceb05b91021811a3c485a67ba9f487955f20d95e102ebd557e817aecd9e7aebf1c600f0d6e2d86ef0996867217dc23371c6fc42032f612a3098094397b16cb6064bb18a1e645d91603bfd8be344b5aeaf6ae1cc58c293861588dac99", 3);
    }
}
