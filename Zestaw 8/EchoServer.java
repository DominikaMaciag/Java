import java.io.*;
import java.net.*;
 
public class EchoServer {
    public static void main(String[] args) throws IOException {
        String firstNumber = "";
        String symbol = "";
        String secondNumber = "";
    
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
 
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                clientSocket.getInputStream()));
        String inputLine;
                
        while ((inputLine = in.readLine()) != null) {
            int i=0;
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
            // System.out.println(firstNumber + " "+ symbol + " " + secondNumber);
            if(symbol.equals("+")){
                int wynik = Integer.parseInt(firstNumber)+Integer.parseInt(secondNumber);
                // System.out.println("działam!" + wynik);
                out.println(wynik);
            }
            if(symbol.equals("*")){
                out.println((Integer.parseInt(firstNumber)*Integer.parseInt(secondNumber)));
            }
            if(symbol.equals(":") || symbol.equals("/")){
                out.println((Double.parseDouble(firstNumber)/Double.parseDouble(secondNumber)));
            }
            if(symbol.equals("-")){
                out.println((Integer.parseInt(firstNumber)-Integer.parseInt(secondNumber)));
            }
        }
         
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
 
    }
}