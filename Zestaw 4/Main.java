import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Cryptographer obj1 = new Cryptographer();
        obj1.cryptfile("tocrypt.txt", "decrypt.txt", null);
    }
}
