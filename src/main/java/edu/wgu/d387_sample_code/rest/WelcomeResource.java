package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.service.TimeConversion;
import edu.wgu.d387_sample_code.service.WelcomeMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@CrossOrigin
public class WelcomeResource {

    @GetMapping("/api/welcome")
    public List<String> getWelcomeMessages() throws InterruptedException {

        List<String> messages = new CopyOnWriteArrayList<>();

        WelcomeMessage englishTask = new WelcomeMessage(Locale.US, messages);
        WelcomeMessage frenchTask = new WelcomeMessage(Locale.CANADA_FRENCH, messages);

        Thread t1 = new Thread(englishTask);
        Thread t2 = new Thread(frenchTask);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        return messages;
    }

    @GetMapping("/api/time-conversion")
    public List<String> getTimeConversionMessages() throws InterruptedException {
        List<String> times = new CopyOnWriteArrayList<>();

        TimeConversion etTime = new TimeConversion(ZoneId.of("America/New_York"), times);
        TimeConversion mtTime = new TimeConversion(ZoneId.of("America/Denver"), times);
        TimeConversion utcTime = new TimeConversion(ZoneId.of("UTC"), times);

        Thread t1 = new Thread(etTime);
        Thread t2 = new Thread(mtTime);
        Thread t3 = new Thread(utcTime);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        return times;
    }
}
