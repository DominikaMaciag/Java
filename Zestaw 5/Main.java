import java.io.FileNotFoundException;
import java.io.IOException;
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        String in = args[0];
        String out = args[1];
        int delay = Integer.valueOf(args[2]);
        int fps = Integer.valueOf(args[3]); 

        MicroDVD micro = new MicroDVD();

        try {
            micro.delay(in, out, delay, fps);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch(IOException  e){
            e.printStackTrace();
        }
        catch(Exception  e){
            e.printStackTrace();
        }
    }
}
