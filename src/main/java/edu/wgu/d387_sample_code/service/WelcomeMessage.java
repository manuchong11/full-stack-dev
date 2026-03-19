package edu.wgu.d387_sample_code.service;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessage implements Runnable {

    private final Locale locale;
    private final List<String> welcomeMessages;

    public WelcomeMessage(Locale locale, List<String> welcomeMessages) {
        this.locale = locale;
        this.welcomeMessages = welcomeMessages;
    }

    @Override
    public void run() {

        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        String message = bundle.getString("welcome.message");

        welcomeMessages.add(message);



    }
}
