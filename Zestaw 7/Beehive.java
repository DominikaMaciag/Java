public class Beehive {
    public int available = 2; // dostępne miejsca w ulu 
    Boolean firstEntranceFree = true; // pszczolka moze wleciec jak jest true
    Boolean secondEntranceFree = true;

    // gdy pszczoła wlatuje:
    // pszczoly najpierw sprawdzają wejście nr 1 dopiero później wejście nr 2
    int flying_in(int id){
        while(true){
            synchronized(this){
                if(available>0){
                    System.out.println("Pszczoła " + id + " podlatuje pod przelot 1");
                    available --;
                    if (firstEntranceFree == true){
                        System.out.println("Pszczoła " + id + " wlatuje przez przelot 1");
                        firstEntranceFree = false;
                        return 1;
                    }
                    if (firstEntranceFree == false) {
                        System.out.println("Pszczoła " + id + " przelot 1 zajęty, sprawdza przelot 2");
                    }
                    if (secondEntranceFree == true){
                        System.out.println("Pszczoła " + id + " wlatuje przez przelot 2");
                        secondEntranceFree = false;
                        return 2;
                    }    
                    if (secondEntranceFree == false){
                        System.out.println("Pszczoła " + id + " przelot 2 zajęty, oczekuję przelot 2");
                    }              
                }
            }
        }
    }

    // gdy pszczoła wylatuje
    void flying_out(int entrance, int id){
        synchronized(this){
            if ( entrance == 1){
                firstEntranceFree = true;
                System.out.println("Pszczoła " + id + " wylatuje z przelotu 1");
            }
            else {
                secondEntranceFree = true;
                System.out.println("Pszczoła " + id + " wylatuje z przelotu 2");
            }
            available ++;
        }
    }
}
