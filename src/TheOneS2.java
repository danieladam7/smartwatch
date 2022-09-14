
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// MAIN CLASS OF THE BRAND "The One s2" (singleton polymorphism class)

public final class TheOneS2{

    //////////          globals         //////////

    private static TheOneS2 theOneS2 = null;

    private ArrayList<ModeBase> modes;
    private HourMode hour;
    private DateMode date;
    private StopwatchMode stopwatch;
    private BrandMode brand;

    private ModeBase initial_mode;
    private ModeBase current_mode;

    // use index
    private int current_mode_index;
    private int initial_mode_index;

    // singleton
    private TheOneS2() throws IOException {
        hour = new HourMode(this);
        date = new DateMode(this);
        stopwatch = new StopwatchMode(this);
        brand = new BrandMode(this);

        modes = new ArrayList();
        modes.add(hour);
        modes.add(date);
        modes.add(stopwatch);
        modes.add(brand);
        initial_mode_index = 0;
        initial_mode = modes.get(initial_mode_index);
        current_mode = initial_mode;

    }

    //////////          getters & setters         //////////
    public static TheOneS2 getInstance() throws IOException {
        if (theOneS2 == null)
            theOneS2 = new TheOneS2();

        return theOneS2;
    }



    protected ModeBase getCurrent_mode(){
        return current_mode;
    }
    protected void setCurrent_mode(ModeBase next) {
        current_mode = next;
    }
    protected ModeBase getInitial_mode() {
        return initial_mode;
    }
    public int getInitial_mode_index() {
        return initial_mode_index;

    }

    protected ArrayList<ModeBase> getModes(){
        return modes;
    }

    protected int getCurrent_mode_index(){
        return current_mode_index;
    }
    protected void setCurrent_mode_index(int next_Mode){
        current_mode_index = next_Mode;
    }

    protected void init_mode(){
        current_mode = initial_mode;
        current_mode_index = 0;
    }



    //////////          watch buttons         //////////

    // move to next mode
    public void doAction_A(){
        current_mode.doAction_A();
    }


    // Button B and C will be implemented different by each successor
    public void doAction_B(){
        current_mode.doAction_B();
    }
    public void doAction_C(){
        current_mode.doAction_C();
    }



}// end class
