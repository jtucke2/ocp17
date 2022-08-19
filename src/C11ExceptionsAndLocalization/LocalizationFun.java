package C11ExceptionsAndLocalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalizationFun {
    public static void main(String[] args) throws ParseException {
        // ~ Currency ~

        var euro = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(43453.55);
        System.out.println(euro); // 43.453,55 €

        var yen = NumberFormat.getCurrencyInstance(Locale.JAPAN).format(43453.55);
        System.out.println(yen); // ￥43,454

        var rupee = NumberFormat.getCurrencyInstance(new Locale("IN")).format(43453.55);
        System.out.println(rupee); // ¤ 43,453.55 - no rupee symbol

        // ~ Numbers ~

        var eurCnt = NumberFormat.getInstance(Locale.GERMANY).format(982743);
        System.out.println(eurCnt); // 982.743

        // ~ Percents ~

        var eurPercent = NumberFormat.getPercentInstance(Locale.GERMANY).format(982743);
        System.out.println(eurPercent); // 98.274.300 %

        // ~ Parse ~

        var parsedYen = NumberFormat.getCurrencyInstance(Locale.JAPAN).parse("￥43,454");
        System.out.println(parsedYen); // 43454

        // ~ CompactNumberFormat ~

        System.out.println(
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT).format(3_000_000) // 3M
        );
        System.out.println(
                NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG).format(3_000_000) // 3 million
        );

        // ~ Date ~

        var formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(Locale.US)
                .format(LocalDate.of(2013, 4, 5));

        System.out.println(formattedDate); // Apr 5, 2013

        // ~ Date time ~

        var formattedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(Locale.GERMAN)
                .format(LocalDateTime.of(2013, 4, 5, 10, 5, 2));

        System.out.println(formattedDateTime); // 05.04.2013, 10:05:02
    }
}
