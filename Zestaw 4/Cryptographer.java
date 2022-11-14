import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Cryptographer {
    
    public void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException{
        String changed = "";
        int i;

        try {
            FileReader fr = new FileReader(path_to_file_in);
            FileWriter fw = new FileWriter(path_to_file_out);

            while((i = fr.read()) != -1) {
                changed += (char)i;
                i++;
            }
            System.out.println(algorithm.crypt(changed));
            fw.write(algorithm.crypt(changed));

            fw.close();
            fr.close();
            // System.out.println("przeczytalismy plik i go zapisalismy");
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException{
        String changed = "";
        int i;

        try { 
            FileReader fr = new FileReader(path_to_file_in);
            FileWriter fw = new FileWriter(path_to_file_out);

            while ((i = fr.read()) != -1){
                changed += (char)i;
                i++;
            }
            System.out.println(algorithm.decrypt(changed));
            fw.write(algorithm.decrypt(changed));

            fw.close();
            fr.close();
            // System.out.println("przeczytalismy plik i go zapisalismy");
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
