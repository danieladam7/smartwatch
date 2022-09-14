import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class StopwatchMode extends ModeBase {

        private Stopwatch stopwatch;
    
    
    
        public StopwatchMode(TheOneS2 theOneS2) {
                super(theOneS2);
        }




        //////////          implementation of watch buttons         //////////

        @Override
        //Button B - start, pause and resume Stopwatch
        public void doAction_B() {
                stopwatch = new Stopwatch();

        }
    
        @Override
        // Button C - reset to 00:00:00
        public void doAction_C() {
                stopwatch = new Stopwatch();
        }





} // end class

