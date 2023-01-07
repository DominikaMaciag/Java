import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class Bees extends Thread{
    Beehive beehive;
    int id;
    
    public void run(){
        int entrance = 0;

        try {
            while(true){
                // przyjmuję, że pszczoły zaczynają od próby wlecenia do któregoś z wejść ula
                entrance = beehive.flying_in(id);
                passing_through(); // pszczoła przechodzi przez wejście
                beehive.flying_out(entrance, id); // pszczoła przeszła przez wejście
                staying_in(); // pszczoła czeka w ulu
                entrance = beehive.flying_in(id); // pszczoła wybiera wyjście
                passing_through(); // pszczoła przechodzi przez wyjście
                beehive.flying_out(entrance, id); // pszczoła przeszła przez wyjście
                staying_out();  // pszczoła zostaje na zewnątrz 
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

    }

    // wejście lub wyjście z ula
    void passing_through() throws InterruptedException{
        // System.out.println("Pszczola o id: "+ id + " przechodzi przez drzwi");
        TimeUnit.SECONDS.sleep(1); // pszczoła wlatuje/wylatuje przez 1 sekundę 
    }

    // przebywa w ulu 1-5 sekund:
    void staying_in() throws InterruptedException{
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        TimeUnit.SECONDS.sleep(randomNum);
        // System.out.println("Pszczola o id: "+ id + " przebywa w ulu " + randomNum + " sekund" );
    }

    // przebywa na zewnątrz 5-10 sekund:
    void staying_out() throws InterruptedException{
        int randomNum2 = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        TimeUnit.SECONDS.sleep(randomNum2);
        // System.out.println("Pszczola o id: "+ id + " przebywa na zewnątrz " + randomNum2 + " sekund");
    }
}
