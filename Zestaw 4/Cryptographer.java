import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Cryptographer {
    
    public void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException{
        // BufferedReader br = new BufferedReader(new FileReader(path_to_file_in));
        String st;
        String changed = "";
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path_to_file_in));
            FileWriter fw = new FileWriter(path_to_file_out);

            while ((st = br.readLine()) != null){
                //System.out.println(st);
                changed += st.charAt(i);
                i++;
            }

            System.out.println(changed);
            fw.write(changed);

            fw.close();
            br.close();
            System.out.println("przeczytalismy plik i go zapisalismy");
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }

        // Algorithm.crypt(input) -> output.txt
    }

    public void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException{
        String st;
        String changed = "";
        int i = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(path_to_file_in));
            FileWriter fw = new FileWriter(path_to_file_out);

            while ((st = br.readLine()) != null){
                //System.out.println(st);
                changed += st.charAt(i);
                i++;
            }

            System.out.println(changed);
            fw.write(changed);

            fw.close();
            br.close();
            System.out.println("przeczytalismy plik i go zapisalismy");
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }

        // Algorithm.decrpt(input) -> output.txt
    }
}
