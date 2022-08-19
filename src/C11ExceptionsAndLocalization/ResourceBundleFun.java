package C11ExceptionsAndLocalization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundleFun {
    public static void main(String[] args) {
        ResourceBundle.getBundle("Cars", Locale.UK).getString("fourDoor"); // saloon

        String greeting = ResourceBundle.getBundle("Greetings", Locale.FRANCE).getString("greeting");
        MessageFormat.format(greeting, "Bob"); // Bonjour, Bob!

    }
}
