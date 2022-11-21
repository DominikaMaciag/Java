// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class MicroDVD {
    
    void delay(String in, String out,int delay, int fps) throws IOException{
        String read = "";
        String liczba = "";
        int i, liczbaInt, liczba1, liczba2;
        
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
                        if ( Character.isDigit((char)i)){
                           liczba += (char)i; 
                        }
                        else {
                            fw.close();
                            fr.close();
                            throw new NumberFormatException("Character is not a number");
                        }
                    }
                }
                if ( i != -1){
                    liczbaInt = Integer.parseInt(liczba)+((delay*fps)/1000);
                    read += Integer.toString(liczbaInt);
                    read+= (char)i;
                    // System.out.println("liczba1: "+liczba);
                    liczba1 = Integer.valueOf(liczba);
                    liczba = "";
                    
                    //drugie {}
                    while((i = fr.read()) != '}'){
                        if((char)i=='{'){
                            read += (char)i;
                        }
                        else {
                            if ( Character.isDigit((char)i)){
                               liczba += (char)i; 
                            }
                            else {
                                fw.close();
                                fr.close();
                                throw new NumberFormatException("Character is not a number");
                            }
                        }
                    }
                    liczbaInt = Integer.parseInt(liczba)+((delay*fps)/1000);
                    read += Integer.toString(liczbaInt);
                    read+= (char)i;
                    
                    liczba2 = Integer.parseInt(liczba);
                    // System.out.println("liczba1: "+liczba1 + "liczba2: " + liczba2);
                    if (liczba2 < liczba1){
                        fw.close();
                        fr.close();
                        throw new IOException("Wrong sequence of frames");
                    }
                    liczba = "";

                    //tekst 
                    while((i = fr.read()) != '\n' ){
                        read += (char)i;
                    }
                    read+= (char)'\n';
                    // System.out.println("read"+read);
                }
                else {
                    break;
                }
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