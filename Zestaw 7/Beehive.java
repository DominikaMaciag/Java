public class Beehive {
    public int available = 2; // dostępne miejsca w ulu 

    // gdy pszczoła wlatuje:
    void flying_in(){
        while(true){
            synchronized(this){
                if(available>0){
                    available --;
                    break;                    
                }
            }
        }
    }

    // gdy pszczoła wylatuje
    void flying_out(){
        synchronized(this){
            available ++;
        }
    }
}
