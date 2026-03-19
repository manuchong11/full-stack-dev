package edu.wgu.d387_sample_code.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeConversion implements Runnable {
    private  final ZoneId zoneId;
    private final List<String> convertedTimes;

    public TimeConversion(ZoneId zoneId, List<String> convertedTimes) {
        this.zoneId = zoneId;
        this.convertedTimes = convertedTimes;
    }

    @Override
    public void run() {

        ZonedDateTime presentationTimeET = ZonedDateTime.now(ZoneId.of("America/New_York")).withHour(20).withMinute(30).withSecond(0).withNano(0);

        ZonedDateTime targetTime = presentationTimeET.withZoneSameInstant(zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = targetTime.format(formatter);

        convertedTimes.add(zoneId.getId() + ": " + formattedTime);
    }

}
