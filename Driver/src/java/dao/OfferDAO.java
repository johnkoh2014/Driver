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
}
