import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String input = args[0];
        String output = args[1];
        String algorithm = args[2]; // crypt or decrypt
        String cipher = args[3]; // ROT11 or Polybius

        if(cipher.equals("rot")){
            ROT11 rot = new ROT11();
            Cryptographer obj = new Cryptographer();
            if(algorithm.equals("crypt")){
                obj.cryptfile(input, output, rot);
            }
            else if(algorithm.equals("decrypt")){
                obj.decryptfile(input, output, rot);
            }
            else{
                System.out.println("podano bledny argument!");
            }
        }
        if(cipher.equalsIgnoreCase("Polibiusz")){
            Polibiusz pol = new Polibiusz();
            Cryptographer obj = new Cryptographer();
            if(algorithm.equals("crypt")){
                obj.cryptfile(input, output, pol);
            }
            else if(algorithm.equals("decrypt")){
                obj.decryptfile(input, output, pol);
            }
            else{
                System.out.println("Podano bledny argument!");
            }
        }
    }
}
