public class Main{

    public static String naszPesel;
    public static void main(String[] args){
        
        for (int i = 0; i < args.length; i++) {
            naszPesel=args[i];
        }

        PESEL.check(naszPesel);
        
        if(PESEL.compare(naszPesel)==true){
            System.out.println("Podany pesel jest taki sam");
        }
        else{
            System.out.println("Pesele sie roznia");
        }
    }
}
