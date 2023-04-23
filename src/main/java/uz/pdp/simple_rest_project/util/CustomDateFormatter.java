package uz.pdp.simple_rest_project.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class CustomDateFormatter {

    public LocalDateTime now() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tashkent"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String format = formatter.format(localDateTime);
        return LocalDateTime.parse(format, formatter);
    }
}
