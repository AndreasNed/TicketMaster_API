package UtilityPackage;

import EventPackage.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Utility {

    public static Event returnEventViaCountryCode(String countryCode) throws IOException {
        String apiKey = "G3VMzlDZHb38ZT02SEimr4wKChWxOOiQ";

        URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?apikey=" + apiKey + "&countryCode=" + countryCode);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output = br.readLine();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Event event = gson.fromJson(output, Event.class);
        
        return event;
    }

}
