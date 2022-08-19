package C4CoreApis;

import java.time.*;
import java.time.temporal.TemporalAmount;

public class DateTimeFun {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2022, 1, 5, 3, 33, 33, 200, ZoneId.of("US/Eastern"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toInstant());

        LocalDate date = LocalDate.of(1990, Month.JULY, 1);
        date.plusYears(3);
        // Still 1990 as the plusYears is an immutable call
        System.out.println(date);
        // Will throw exception
//        addToJanOne1999(Duration.ofHours(24));


    }

    static LocalDate addToJanOne1999(TemporalAmount period) {
        LocalDate date = LocalDate.of(1999, Month.JANUARY, 1);
        return date.plus(period);
    }

}
