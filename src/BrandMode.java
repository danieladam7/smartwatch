import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;


public class BrandMode extends ModeBase{

    //////////          globals         //////////

    private FileWriter fileWriter;

    public BrandMode(TheOneS2 theOneS2) throws IOException {
        super(theOneS2);
        fileWriter = new FileWriter("output.txt");
    }



    //////////          implementation of watch buttons         //////////

    @Override
    // Button B - write into output file
    public void doAction_B() {
        try {
            fileWriter.write("The One s2!");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    // Button C - do nothing
    public void doAction_C() {
        return; // do nothing
    }


} // end class
