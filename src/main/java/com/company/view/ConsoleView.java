package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;
import static com.company.view.ViewConstants.*;

/**
 * Class for view
 * @author Hodik Timofey
 */

public class ConsoleView {

    private void printMessage(String message){
       System.out.println(message);
    }


    // Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "message";

    private static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ukr", "UKR"));  // Ukrainian
                    //new Locale("ru", "RU"));  // Ukrainian
                    new Locale("en"));        // English

    /**
     * concatenate String params
     * @param message some number of messages
     * @return String full message
     */

    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString.append(v);
        }
        return new String(concatString);
    }

    /**
     * Printing universal message using <b> resourceBundle <b/> and <b> message </b>
     * @param resourceBundle file .properties
     * @param message message that coming with resource bundle
     */
    public void printUniversalMessage(String resourceBundle, String message){
        printMessage(concatenationString(bundle.getString(resourceBundle), message));
    }

    public void printMessageWagonsInDiapason(int minBarrier, int maxBarrier, String arrayMessage){
        printMessage(concatenationString(bundle.getString(PRINT_TRAIN_WAGONS_IN_DIAPASON),
                OPEN_BRACKET,
                String.valueOf(minBarrier),
                " ",
                String.valueOf(maxBarrier),
                CLOSE_BRACKET, "\n",
                arrayMessage));
    }


}
