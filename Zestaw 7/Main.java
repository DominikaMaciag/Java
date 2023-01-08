
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Beehive ul = new Beehive();
        long timeOfExcecution = 5;
        int numberOfBees = 5; // na razie jako zmienna później jako argument uruchamiania programu
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
