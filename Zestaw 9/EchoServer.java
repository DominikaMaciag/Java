import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer{
    public static void main(String[] args) throws IOException {
        // Tworzymy thread pool z 3 wątkami 
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
 
        try {
            while(true){
                    MyThread thr = new MyThread(); 
                    thr.cSocket = serverSocket.accept();
                    executor.execute(thr);
            }
        } 
        catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
        } 
        finally{
            serverSocket.close();   
        } 
    }
}