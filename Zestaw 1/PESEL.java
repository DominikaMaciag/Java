public class PESEL { 
    public static String samplePesel = "44051401458";
    public static int strChar1;
    public static int strChar2;

    public PESEL(){} //default constructor

    public PESEL(String pesel){  } //custom constructor

    public static Boolean compare(String pesel){   //Metoda compare porównuje czy PESELE są identyczne
        for(int i=0; i<pesel.length(); i++){
            strChar1 = (int)pesel.charAt(i);
            strChar2 = (int)samplePesel.charAt(i);            
            if(strChar1 != strChar2) { 
                break;                
            }
        }
        if (strChar1==strChar2) {
            return true;
        }   
        return false;     
    }

    public static void check(String pesel){ //Metoda check sprawdza czy podany pesel jest prawidlowy
        if(pesel.length()%11==0){
            try {
                Long.parseLong(pesel);
                System.out.println("Podany pesel jest prawidlowy ");
            }
            catch(NumberFormatException e) { 
                throw e;
            }

            if (compareControlNumber(pesel) == true ) {
                System.out.println("Liczba kontrolna jest prawidlowa");
            }
            else System.out.println("Podany pesel ma nieprawidlowa liczbe kontrolna");
        }    
        else { 
            System.out.println("Podany pesel ma nieprawidlowa dlugosc");
        }    
    }

    public static Boolean compareControlNumber(String pesel){
        int suma = Character.getNumericValue(pesel.charAt(0))*1 
        + Character.getNumericValue(pesel.charAt(1))*3 + Character.getNumericValue(pesel.charAt(2))*7 
        + Character.getNumericValue(pesel.charAt(3))*9 + Character.getNumericValue(pesel.charAt(4))*1 
        + Character.getNumericValue(pesel.charAt(5))*3 + Character.getNumericValue(pesel.charAt(6))*7 
        + Character.getNumericValue(pesel.charAt(7))*9 + Character.getNumericValue(pesel.charAt(8))*1 
        + Character.getNumericValue(pesel.charAt(9))*3;

        int m = suma%10;
        int sumaKontrolna = 10 - m;
            
        if( sumaKontrolna == Character.getNumericValue(pesel.charAt(10))){
            return true;
        }
        else {
            return false;
        }
    }
}

