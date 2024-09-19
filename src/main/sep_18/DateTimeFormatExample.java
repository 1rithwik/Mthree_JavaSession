package main.sep_18;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatExample {
    Date d = new Date();
    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = sdf.format(d);

    public static void main(String[] args) {
        DateTimeFormatExample df = new DateTimeFormatExample();
        System.out.println("Formatted Date: " + df.formattedDate);
        System.out.println("Formatted Date: " + LocalDateTime.now().format(df.dtf));
    }
}
