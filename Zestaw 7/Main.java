import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Beehive ul = new Beehive();
        long timeOfExcecution = 50; 
        BufferedReader bfn = new BufferedReader(
            new InputStreamReader(System.in));
        System.out.println("Podaj maksymalną ilość pszczół: ");
        String str = bfn.readLine();
        int numberOfBees = Integer.parseInt(str);
        Bees[] beeArray = new Bees[numberOfBees];


        for(int i = 0; i<numberOfBees; i++){
            Bees bee = new Bees();
            bee.beehive = ul;
            bee.timeOfExcecution = timeOfExcecution;
            bee.id = i;
            bee.start();
            beeArray[i] = bee;
        }  

        for(int i = 0; i<numberOfBees; i++){
            beeArray[i].join();
        }  
    }
}
