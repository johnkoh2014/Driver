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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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

        offer = new Offer(offerId, serviceId, serviceName, openingHour, wsId, shopName, shopAddress, shopCategory, brandsCarried, website, status, initialMinPrice, initialMaxPrice, diagnosticPrice, finalPrice, estCompletionDateTime);
        return offer;

    }

}