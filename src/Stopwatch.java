import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{


    //////////             init frame for stopwatch    //////////

    JFrame frame = new JFrame();
    JButton start_button = new JButton("Start");
    JButton reset_Button = new JButton("Reset");
    JLabel time_label = new JLabel();
    JLabel mode_label = new JLabel();
    int elapsed_time = 0;
    int seconds =0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    // timer works in seconds
    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsed_time = elapsed_time+1000;
            hours = (elapsed_time/3600000);
            minutes = (elapsed_time/60000) % 60;
            seconds = (elapsed_time/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            time_label.setText(hours_string+":"+minutes_string+":"+seconds_string);

        }

    });

    // constructor for stopwatch
    Stopwatch(){


        // config
        frame.setTitle("The One s2 - Stopwatch");
        frame.setSize(420,420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        time_label.setText(hours_string+":"+minutes_string+":"+seconds_string);
        time_label.setBounds(100,100,240,100);
        time_label.setFont(new Font("arial",Font.ITALIC,35));
        time_label.setBorder(BorderFactory.createBevelBorder(2));
        time_label.setOpaque(true);
        time_label.setHorizontalAlignment(JTextField.CENTER);

        start_button.setBounds(100,200,120,50);
        start_button.setFont(new Font("arial",Font.ITALIC,20));
        start_button.setFocusable(false);
        start_button.addActionListener(this);

        reset_Button.setBounds(220,200,120,50);
        reset_Button.setFont(new Font("arial",Font.ITALIC,20));
        reset_Button.setFocusable(false);
        reset_Button.addActionListener(this);

        frame.add(start_button);
        frame.add(reset_Button);
        frame.add(time_label);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==start_button) {

            if(started == false) {
                started = true;
                start_button.setText("Pause");
                start();
            }
            else {
                started=false;
                start_button.setText("Resume");
                stop();
            }

        }
        if(e.getSource()==reset_Button) {
            started=false;
            start_button.setText("Start");
            reset();
        }

    }

    void start() {
        timer.start();
    }

    void stop() {
        timer.stop();
    }

    void reset() {
        timer.stop();
        elapsed_time=0;
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        time_label.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }


    //////////                                      //////////


} // end class stopwatch