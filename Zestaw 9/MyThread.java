import java.io.*;
import java.net.*;

public class MyThread implements Runnable{
    Socket cSocket = null;

    public static String primeNumbers(int start, int end){
        Boolean isPrime;
        int i,j;
        String s = ""; 

        for(i = start; i <= end; i++){
            if(i==0 || i==1){
                continue;
            }

            isPrime = true; // czy jest liczbą pierwszą

            for(j=2; j<=i/2; j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime==true){
                // System.out.print(i+ " ");
                s += Integer.toString(i);
                s += " ";
            }
        }
        return s;
    }

    public void run(){
        int i=0;
        String firstNumber = "";
        String symbol = "";
        String secondNumber = "";
        String inputLine; 

        try{
            PrintWriter outWriter = new PrintWriter(cSocket.getOutputStream(), true);
            BufferedReader inReader = new BufferedReader(
                                    new InputStreamReader(
                                    cSocket.getInputStream()));

            while ((inputLine = inReader.readLine()) != null) {
                firstNumber = "";
                symbol = "";
                secondNumber = "";

                for(i=0; i<inputLine.length() && inputLine.charAt(i)>='0' && inputLine.charAt(i)<='9'; i++){
                    firstNumber += inputLine.charAt(i);
                }
                for(; i<inputLine.length()&& !(inputLine.charAt(i)>='0' && inputLine.charAt(i)<='9'); i++){
                    symbol += inputLine.charAt(i);
                }
                for(; i<inputLine.length() && inputLine.charAt(i)>='0' && inputLine.charAt(i)<='9'; i++){
                    secondNumber += inputLine.charAt(i);
                }

                if(symbol.equals(";")){
                    outWriter.println(primeNumbers(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber)));
                }    
                else {
                    outWriter.println("Podano błędny symbol!");
                } 
            }
            cSocket.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }  
}
