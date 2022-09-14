import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class HourMode extends ModeBase {

    //////////          globals         //////////

    private ZoneId zoneId; // use local zone to avoid default zone
    private LocalTime current_time;
    private String time_pattern;
    private String time_AM_PM;


    public HourMode(TheOneS2 theOneS2) {
        super(theOneS2);
        zoneId = Calendar.getInstance().getTimeZone().toZoneId();
        current_time = LocalTime.now(zoneId);
        time_pattern = "hh:mm a"; // AM/PM format
        time_AM_PM = current_time.format(DateTimeFormatter.ofPattern(time_pattern));
    }



    //////////          implementation of watch buttons         //////////


    // Button B - print current time in AM/PM
    @Override
    public void doAction_B() {
        System.out.println(time_AM_PM);
    }

    @Override
    // Button C - display alarm clock which starts after 2 minutes
    public void doAction_C() {
        //for bonus
        AlarmClock alarm = new AlarmClock();
        alarm.runTimer();
    }





} // end class
