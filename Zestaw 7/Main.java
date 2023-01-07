
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Beehive ul = new Beehive();
        int numberOfBees = 3; // na razie jako zmienna później jako argument uruchamiania programu
        Bees[] beeArray = new Bees[numberOfBees];

        for(int i = 0; i<numberOfBees; i++){
            Bees bee = new Bees();
            bee.beehive = ul;
            bee.id = i;
            bee.start();
            beeArray[i] = bee;
        }            
    }
}
