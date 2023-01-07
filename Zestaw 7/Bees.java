import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class Bees extends Thread{
    Beehive beehive;
    int id;
    
    public void run(){
        try {
            while(true){
                beehive.flying_in();
                passing_through();
                beehive.flying_out();
                staying_in();
                beehive.flying_in();
                passing_through();
                beehive.flying_out();
                staying_out();  
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 

    }

    // wejście lub wyjście z ula
    void passing_through() throws InterruptedException{
        System.out.println("Pszczola o id: "+ id + " przechodzi przez drzwi");
        TimeUnit.SECONDS.sleep(1); // pszczoła wlatuje/wylatuje przez 1 sekundę 
    }

    // przebywa w ulu 1-5 sekund:
    void staying_in() throws InterruptedException{
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        TimeUnit.SECONDS.sleep(randomNum);
        System.out.println("Pszczola o id: "+ id + " przebywa w ulu " + randomNum + " sekund" );
    }

    // przebywa na zewnątrz 5-10 sekund:
    void staying_out() throws InterruptedException{
        int randomNum2 = ThreadLocalRandom.current().nextInt(5, 10 + 1);
        TimeUnit.SECONDS.sleep(randomNum2);
        System.out.println("Pszczola o id: "+ id + " przebywa na zewnątrz " + randomNum2 + " sekund");
    }
}
