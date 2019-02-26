package RestClientPackage;

import EventPackage.Event;
import EventPackage.Events;
import UtilityPackage.Utility;
import java.io.IOException;
import java.util.Scanner;

public class RestClient {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("type '0' to exit");
            System.out.print("Enter a country code: ");
            String code = sc.nextLine();
            
            if(code.equals("0")){
                System.exit(0);
            }
            
            Event event;
            event = Utility.returnEventViaCountryCode(code);
            readEvents(event);

        }

    }

    public static void readEvents(Event event) {        

        Events[] eventAmount = event.get_embedded().getEvents();        
        
        for (int i = 0; i < eventAmount.length; i++) {
            System.out.println("Name: "+event.get_embedded().getEvents()[i].getName());
            System.out.println("Webpage: "+event.get_embedded().getEvents()[i].getUrl());
            System.out.println("Event ID: "+event.get_embedded().getEvents()[i].getId());
            System.out.println("");
        }
    }
}
