
public abstract class ModeBase {

    private TheOneS2 myWatch;

    // constructor in abstract class to init myWatch
    public ModeBase(TheOneS2 theOneS2){
        myWatch = theOneS2;
    }

    //////////          implementation of watch buttons         //////////
    public void doAction_A(){
        if(myWatch.getCurrent_mode_index() < myWatch.getModes().size()-1){
            int next_mode_index = myWatch.getCurrent_mode_index()+1;
            ModeBase next = myWatch.getModes().get(next_mode_index);
            myWatch.setCurrent_mode(next);
            myWatch.setCurrent_mode_index(next_mode_index);


        }
        else{
            myWatch.init_mode();

        }
    }

    // will be implemented differently by each successor
    abstract void doAction_B();
    abstract void doAction_C();


}
