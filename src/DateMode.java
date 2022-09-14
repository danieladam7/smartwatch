import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class DateMode extends ModeBase {

    //////////          globals         //////////

    private ZoneId zoneId;
    private LocalDate date;
    private int year;
    private DayOfWeek day;


    DateMode(TheOneS2 theOneS2){
        super(theOneS2);
        zoneId = Calendar.getInstance().getTimeZone().toZoneId();
        date = LocalDate.now(zoneId);
        year = date.getYear();
        day = date.getDayOfWeek();    }



    //////////          implementation of watch buttons         //////////

    @Override
    // Button B - print current year (e.g. "2022")
    public void doAction_B() {
        System.out.println(year);
    }

    @Override
    // Button C - print name of current week day
    public void doAction_C() {
        System.out.println(day.getDisplayName(TextStyle.FULL, Locale.getDefault()));

    }




} // end class
