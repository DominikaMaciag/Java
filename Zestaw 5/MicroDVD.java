// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class MicroDVD {
    
    void delay(String in, String out,int delay, int fps){
        String read = "";
        String liczba = "";
        int i, liczbaInt;

        try {
            FileReader fr = new FileReader(in);
            FileWriter fw = new FileWriter(out);

            while(true) {
                //pierwsze {}
                while((i = fr.read()) != '}' && i!=-1){
                    if((char)i=='{'){
                        read += (char)i;
                    }
                    else {
                        liczba += (char)i;
                    }
                }
                if ( i != -1){
                    liczbaInt = Integer.parseInt(liczba)+((delay*fps)/1000);
                    read += Integer.toString(liczbaInt);
                    read+= (char)i;
                    // System.out.println("read"+read);
                    liczba = "";
                    
                    //drugie {}
                    while((i = fr.read()) != '}'){
                        if((char)i=='{'){
                            read += (char)i;
                        }
                        else {
                            liczba += (char)i;
                        }
                    }
                    liczbaInt = Integer.parseInt(liczba)+((delay*fps)/1000);
                    read += Integer.toString(liczbaInt);
                    read+= (char)i;
                    // System.out.println("read"+read);
                    liczba = "";

                    //tekst 
                    while((i = fr.read()) != '\n' ){
                        read += (char)i;
                    }
                    read+= (char)'\n';
                    // System.out.println("read"+read);
                }
                else break;
            }

            fw.write((read));
            fw.close();
            fr.close();
        } 
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}