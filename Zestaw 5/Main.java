import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MicroDVD micro = new MicroDVD();
        micro.delay("gravity.txt", "gravity-delayed.txt", 100, 25);

    }
}
