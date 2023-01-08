import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class Bees extends Thread{
    Beehive beehive;
    int id;
    long timeOfExcecution;
    long timeWaitingIn;
    long sumOftimeWaitingIn=0;
    long timeWaitingOut;
    long sumOftimeWaitingOut=0;
    int numberOfFlyingIn=0;
    int numberOfFlyingOut=0;
    
    public void run(){
        int entrance = 0;
        long timeBegin = System.currentTimeMillis();
        try {
            while(System.currentTimeMillis()-timeBegin<timeOfExcecution*1000){
                // przyjmuję, że pszczoły zaczynają od próby wlecenia do któregoś z wejść ula
                long startTime = System.currentTimeMillis();
                entrance = beehive.flyingIn(id);
                long stopTime = System.currentTimeMillis();
                timeWaitingIn = stopTime - startTime;
                sumOftimeWaitingIn += timeWaitingIn;
                numberOfFlyingIn ++;
                // System.out.println("     ---->czas oczekiwania in: " + (timeWaitingIn) + " in: " + numberOfFlyingIn);

                passingThrough(); // pszczoła przechodzi przez wejście
                beehive.flyingOut(entrance, id); // pszczoła przeszła przez wejście
                stayingIn(); // pszczoła czeka w ulu

                long startTimeOut = System.currentTimeMillis();
                entrance = beehive.flyingIn(id); // pszczoła wybiera wyjście
                long stopTimeOut = System.currentTimeMillis();
                timeWaitingOut = stopTimeOut - startTimeOut;
                sumOftimeWaitingOut += timeWaitingOut;
                numberOfFlyingOut ++;
                // System.out.println("     ---->czas oczekiwania out: " + (timeWaitingOut)  + " out: " + numberOfFlyingOut);

                passingThrough(); // pszczoła przechodzi przez wyjście
                beehive.flyingOut(entrance, id); // pszczoła przeszła przez wyjście
                stayingOut();  // pszczoła zostaje na zewnątrz 
            }
            // ** Informacja: czas jest podany w milisekundach
            // w pliku zapisujemy dane na temat średniego czasu wlotu/wylotu
            // oraz ilość wlotów/wylotów każdej pszczoły
            File log = new File("log.txt");
            if(log.exists()==false){
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("Pszczoła o id: "+ id + " czas średni na wlot (ms): " + sumOftimeWaitingIn/numberOfFlyingIn 
            + " ilość wlotów: " + numberOfFlyingIn + "\n");
            out.append("Pszczoła o id: "+ id + " czas średni na wylot (ms): " + sumOftimeWaitingOut/numberOfFlyingOut 
            + " ilość wylotów: " + numberOfFlyingOut + "\n");
            out.close();
        } 
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } 
    }

    // wejście lub wyjście z ula
    void passingThrough() throws InterruptedException{
        TimeUnit.SECONDS.sleep(1); // pszczoła wlatuje/wylatuje przez 1 sekundę 
    }

    // przebywa w ulu 1-5 sekund:
    void stayingIn() throws InterruptedException{
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        TimeUnit.SECONDS.sleep(randomNum);
    }

    // przebywa na zewnątrz 5-10 sekund:
    void stayingOut() throws InterruptedException{
        int randomNum2 = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        TimeUnit.SECONDS.sleep(randomNum2);
    }
}
