import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Cryptographer obj1 = new Cryptographer();
        // obj1.cryptfile("tocrypt.txt", "decrypt.txt", null);

        String test = "I 12 lat.";
        String test2 = "T CD wl4.";
        ROT11 r1 = new ROT11();
        System.out.println(r1.crypt(test));
        System.out.println(r1.decrypt(test2));
    }
}
