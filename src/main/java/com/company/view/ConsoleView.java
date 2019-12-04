package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;
import static com.company.view.ViewConstants.*;


public class ConsoleView {

    public void printMessage(String message){
       System.out.println(message);
    }


    // Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "message";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ukr", "UKR"));  // Ukrainian
                    //new Locale("ru", "RU"));  // Ukrainian
                    //new Locale("en"));        // English


    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString.append(v);
        }
        return new String(concatString);
    }

    public void printUniversalMessage(String resourceBundle, String message){
        printMessage(concatenationString(bundle.getString(resourceBundle), message));

    }



}
