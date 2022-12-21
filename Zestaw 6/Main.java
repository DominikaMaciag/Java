
public class Main {

    public static void main(String[] args) {
        DataFrame d = new DataFrame(null, args);
        DataFrame.ApplayableThread t = d.new ApplayableThread(null, null);
        t.start();        
    }
}