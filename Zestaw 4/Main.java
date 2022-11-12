import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Cryptographer obj1 = new Cryptographer();
        // obj1.cryptfile("tocrypt.txt", "decrypt.txt", null);

        System.out.println("\n"+"Test ROT11:");
        String test = "I 12 lat.";
        String test2 = "T CD wl4.";
        ROT11 r1 = new ROT11();
        System.out.println(r1.crypt(test));
        System.out.println(r1.decrypt(test2));

        System.out.println("\n"+"Test Polibiusz:");
        String test3 = "Ala ma kota";
        String test4 = "113111 3211 25344411";
        Polibiusz pol1 = new Polibiusz();
        System.out.println(pol1.crypt(test3));
        System.out.println(pol1.decrypt(test4)); 
    }
}
