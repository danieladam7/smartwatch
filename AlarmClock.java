
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class AlarmClock {

    JFrame frame;
    JLabel counter_label;
    JLabel alarm_label;
    Timer timer;
    int second;
    int minute;
    String ddSecond;
    String ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");


    // constructor
    public AlarmClock() {


        frame = new JFrame();
        frame.setTitle("The One s2 - Alarm clock");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        counter_label = new JLabel();
        counter_label.setBounds(100, 100, 200, 60);
        counter_label.setHorizontalAlignment(JLabel.CENTER);
        Font counter_design = new Font("arial", Font.ITALIC, 50);
        counter_label.setFont(counter_design);

        alarm_label = new JLabel();
        alarm_label.setText("!!! Alarm !!!");
        alarm_label.setBounds(150, 110, 100, 90);
        alarm_label.setHorizontalAlignment(JLabel.CENTER);
        Font alarm_design = new Font("arial", Font.ITALIC, 20);
        alarm_label.setFont(alarm_design);

        frame.add(counter_label);
        frame.setVisible(true);

        // Countdown Timer
        counter_label.setText("02:00");
        second =0;
        minute = 2;
        runTimer();
        timer.start();
    }


    public void runTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counter_label.setText(ddMinute + ":" + ddSecond);
                if(second==-1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counter_label.setText(ddMinute + ":" + ddSecond);
                }
                boolean time_over = minute==0 && second==0;
                if(time_over) {
                    timer.stop();
                    frame.add(alarm_label);
                    frame.setVisible(true);
                }
            }
        });



    }




    public static void main(String[] args) {
        // test
        new AlarmClock();
    }


}//end class

