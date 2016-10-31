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
import entity.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author Joanne
 */
public class VehicleDAO {

    private static final String USER_AGENT = "Mozilla/5.0";

    public Vehicle getVehicle(int user_id, String token, int givenId) throws UnsupportedEncodingException, IOException {

        //Add URL here
        String url = "http://119.81.43.85/erp/vehicle/get_vehicle_by_id";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        //Add parameters here
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("id", givenId + ""));

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
        Vehicle vehicle = null;
        if (isSuccess.getAsString().equals("false")) {
            return vehicle;
        } else {
            jobj = element.getAsJsonObject().getAsJsonObject("payload").getAsJsonObject("vehicle");
            JsonElement attElement = jobj.get("id");
            int id = attElement.getAsInt();
            attElement = jobj.get("make");
            String make = attElement.getAsString();
            attElement = jobj.get("model");
            String model = attElement.getAsString();
            attElement = jobj.get("year");
            int year = attElement.getAsInt();
            attElement = jobj.get("plate_number");
            String plateNumber = attElement.getAsString();
            attElement = jobj.get("user_id");
            int customerID = attElement.getAsInt();
            attElement = jobj.get("car_color");
            String color = attElement.getAsString();
            attElement = jobj.get("type_of_control_of_car");
            String control = attElement.getAsString();
            vehicle = new Vehicle(id, make, model, year, plateNumber, customerID, color, control);
            return vehicle;
        }
    }

    public HashMap<Integer, ArrayList<String>> retrieveAllCarBrands(int user_id, String token) throws UnsupportedEncodingException, IOException {
        HashMap<Integer, ArrayList<String>> list = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> carBrands = new ArrayList<String>();
        ArrayList<String> carModels = new ArrayList<String>();
        ArrayList<String> yearList = new ArrayList<String>();
        String url = "http://119.81.43.85/erp/avalible_car/get_all_avalible_car";

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

        JsonElement brandsElement = jobj.get("payload");
        JsonObject brands = null;
        if (brandsElement.isJsonNull()) {
            return list;
        } else {
            brands = brandsElement.getAsJsonObject();
            JsonArray brandsArr = brands.getAsJsonArray("available_cars");
            for (int i = 0; i < brandsArr.size(); i++) {
                JsonElement brandArr = brandsArr.get(i);
                JsonObject brandObj = brandArr.getAsJsonObject();
                JsonElement attElement = brandObj.get("car_brand");
                String brand = "";
                if (!attElement.isJsonNull()) {
                    brand = attElement.getAsString();
                    if (!carBrands.contains(brand)) {
                        carBrands.add(brand);
                    }
                }
                attElement = brandObj.get("car_models");
                String models = "";
                if (!attElement.isJsonNull()) {
                    models = attElement.getAsString();
                    if (!carModels.contains(models)) {
                        carModels.add(models);
                    }
                }
                attElement = brandObj.get("car_model_year");
                String year = "";
                if (!attElement.isJsonNull()) {
                    year = attElement.getAsString();
                    if (!yearList.contains(year)) {
                        yearList.add(year);
                    }
                }
            }
            list.put(1, carBrands);
            list.put(2, carModels);
            list.put(3, yearList);
        }
        return list;
    }

    public ArrayList<Vehicle> getAllVehicles(int user_id, String token) throws UnsupportedEncodingException, IOException {

        ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
        String url = "http://119.81.43.85/car/get_cars_by_user_id";

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
            return vList;
        } else {
            JsonArray arr = jobj.getAsJsonObject("payload").getAsJsonArray("vehicle");
            for (int i = 0; i < arr.size(); i++) {
                JsonElement qrElement = arr.get(i);
                JsonObject qrObj = qrElement.getAsJsonObject();
                JsonElement attElement = qrObj.get("id");
                int id = 0;
                if (!attElement.isJsonNull()) {
                    id = attElement.getAsInt();
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
                int driverId = 0;
                if (!attElement.isJsonNull()) {
                    driverId = attElement.getAsInt();
                }

                attElement = qrObj.get("car_color");
                String carColor = "";
                if (!attElement.isJsonNull()) {
                    carColor = attElement.getAsString();
                }

                attElement = qrObj.get("type_of_control_of_car");
                String carControl = "";
                if (!attElement.isJsonNull()) {
                    carControl = attElement.getAsString();
                }
                Vehicle vehicle = new Vehicle(id, make, model, year, plate_number, driverId, carColor, carControl);
                vList.add(vehicle);
            }
            return vList;
        }
    }

    public String deleteVehicle(int user_id, String token, int id) throws UnsupportedEncodingException, IOException {
        String url = "http://119.81.43.85/car/delete_car";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("id", id + ""));

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

    public ArrayList<String> addVehicle(String make, String model, int year, int user_id, String plate_number,
            String token, String car_color, String type_of_control_of_car) throws UnsupportedEncodingException, IOException {

        String url = "http://119.81.43.85/car/add_car";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("make", make));
        urlParameters.add(new BasicNameValuePair("model", model));
        urlParameters.add(new BasicNameValuePair("year", year + ""));
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("plate_number", plate_number));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("car_color", car_color));
        urlParameters.add(new BasicNameValuePair("type_of_control_of_car", type_of_control_of_car));

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
        } else {
            JsonElement ele = jobj.get("payload");
            JsonObject obj = ele.getAsJsonObject();
            JsonElement attElement = obj.get("id");
            String id = "";
            if (!attElement.isJsonNull()) {
                id = attElement.getAsString();
                errors.add(id);
            }
        }
        return errors;
    }

    public static void main(String[] args) throws IOException {
        //getVehicle(18, "cb2341be42e49a320f0dbba633e242254956ca9bb800485c757a6e37284fc9693c28a333b39df2791c5a8f88fe136c4060fb65814c807c7cc7acc897a529fc6d22ca19d35ee58820a3571eda94eae9c7c8ca3d76e7501e7df79840f3ede675f0b042cf09ca4e0dfe3ef7a21a4ea49bb0ae14225354831375b78acc64b0bdb6088b9693747d3e145715caa1f3e0dac23bf5190c37ef119f300a3ca1ac0ab18dd9a39c244e1fe7aeab8ad409e365d35a95a01ed3f2467b94fc97aadc2e4cb75482c517edb9e542387fa205b5549d89cae8463bf446cbb4c92b725cd99da45109badf09f2abd13c0d54143f3071186640a7fb1f100b849e5f6c6e1fbcbfa91a1ccec982b106d80b3d21a011f75e82ca16cb7f5d820374e1fd074b5373a367d1cf4c49668b790c3b761df624862302c78acd282c1f3d36eedb98e3d33bcf0b2ed2285490f953e0c588f65a893f07dbd49fbbe4211f898c23b3713358bbe00c0d0574a95256a5bfec7ae42a12f4df75a359fd7dd44d2c72430bb0426e1429fc5e9dad491e8cdb520d0f61b271efde9fe74a24baf208c542bdd49d9eab9a6d3eb836468b7c295d3d9792398b1287c86dd5fb59427cf8e038f1b2643e1dda27b9f4ac99fddf0af3b942d34b2f3b8d36c07b2552fdba09c535162e7eabfb80291f5b6e0087dfe5fcabf9a1384ca93d81923773ce6fd28e1efec778c656e7f379af9b994f", 1);
        //addVehicle("temp2", "temp2", 1233, 337, "1234", "1c21fa2b0e16cc95e4f3c837b36c812d9588e465a2d770c77b73c9e4744cb60fff61accec3ad0b37e649adf08fe551f4d4c70eff4e9233922ac4c256428589e696f055593e3393fbd2f335358985f815d7f984055b8ff2d977482dfc0bf4c915057b819fb6079edef02a88bde1d3241b7dfaaaf7bac9d4a74a3deb4ef838ac0529026ec97f88ab379a2e0c15340a857a775b0ac7f59b7a74586131084e1cbf66764f37a479e8621bd788d95c4d1f6d82a7ea2fa760a482cdf8b6f593f3d742a073b71a219197f49122fc1784fa4f4b7ed84371d33b4bf2e25a3dfa23a2b1501cf35b5434cb0a1678a7053efa43b0a533bcd288b3134cf0f81cae2f43e8ff14d72579f90a6ca86014ceab4992b5d352bb24bdc570ab8eabcfcd35b46a6c023df46bce56d51ea582d30da14bc84928d346346f1c93312fbd3ee784024f05da80a59ba8f9b733962b30165780af8697f3399a9994eac0c170029308efa00be5d0343e80c5390f3d91d82380003beea5d51b770e0a03c706c4f9ffec142c15f2a6de6cd392f3aa11b4cab14814205471e4abe371e3843aae412321fb8cde228eb66dfe812585f3324e192289a405e59297d7e1d9301bf49328f174a0e4b90df82064075b43d3c2539b3c09ff2f24d9dbbe00f913170696c912a84fef61563cc5f2b5e0a6b858441db2bb26b23ebeb1947ab235d9149e5eb46d09d154024d0c8a217a", "blue", "auto");
    }

    public ArrayList<String> editVehicle(int id, String make, String model, int year, int user_id, String plate_number,
            String token, String car_color, String type_of_control_of_car) throws UnsupportedEncodingException, IOException {

        String url = "http://119.81.43.85/car/edit_car";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        // add header
        post.setHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("id", id+""));
        urlParameters.add(new BasicNameValuePair("make", make));
        urlParameters.add(new BasicNameValuePair("model", model));
        urlParameters.add(new BasicNameValuePair("year", year + ""));
        urlParameters.add(new BasicNameValuePair("user_id", user_id + ""));
        urlParameters.add(new BasicNameValuePair("plate_number", plate_number));
        urlParameters.add(new BasicNameValuePair("token", token));
        urlParameters.add(new BasicNameValuePair("car_color", car_color));
        urlParameters.add(new BasicNameValuePair("type_of_control_of_car", type_of_control_of_car));

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
