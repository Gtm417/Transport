package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleView {

    public void printMessage(String message){
       System.out.println(message);
    }


    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ukr", "UKR"));  // Ukrainian
                    new Locale("en"));        // English


    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString.append(v);
        }
        return new String(concatString);
    }
}
