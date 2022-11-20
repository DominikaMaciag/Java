// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class MicroDVD {
    
    void delay(String in, String out,int delay, int fps){
        String read = "";
        String liczba = "";
        int i;

        try {
            FileReader fr = new FileReader(in);
            FileWriter fw = new FileWriter(out);

            while((i = fr.read()) != -1) {
                if((char)i!='}'){
                    if((char)i=='{'){
                        read += (char)i;
                    }
                    else {
                        liczba += (char)i;
                    }
                    // System.out.println("liczba to" + liczba);
                }
                else{
                    int liczbaInt = Integer.parseInt(liczba)+((delay*fps)/1000);
                    read += Integer.toString(liczbaInt);
                    System.out.println("read"+read);
                    break;
                }
                
            }
            //System.out.println(delay(changed));
            //fw.write(algorithm.crypt(changed));
            fw.write((read));

            fw.close();
            fr.close();
            // System.out.println("przeczytalismy plik i go zapisalismy");
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}