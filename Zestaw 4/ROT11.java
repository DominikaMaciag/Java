public class ROT11 implements Algorithm{
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    int rotation = 11;
    String changed = "";
    
    @Override
    public String crypt(String inputWord) {
        for(int i=0; i< inputWord.length(); i++){
            if(inputWord.charAt(i)<'0' | inputWord.charAt(i)>'9' & inputWord.charAt(i)<'A' | inputWord.charAt(i)>'Z'
            & inputWord.charAt(i)<'a' | inputWord.charAt(i)>'z'){
                changed += inputWord.charAt(i);
            }
            for(int j=0; j< alphabet.length(); j++){
                if(inputWord.charAt(i)==alphabet.charAt(j)){
                    changed += alphabet.charAt((j+rotation)%alphabet.length());
                }
            }
        }
        return changed;
    }

    @Override
    public String decrypt(String inputWord) {
        changed= "";
        for(int i=0; i< inputWord.length(); i++){
            if(inputWord.charAt(i)<'0' | inputWord.charAt(i)>'9' & inputWord.charAt(i)<'A' | inputWord.charAt(i)>'Z'
            & inputWord.charAt(i)<'a' | inputWord.charAt(i)>'z'){
                changed += inputWord.charAt(i);
            }
            for(int j=0; j< alphabet.length(); j++){
                if(inputWord.charAt(i)==alphabet.charAt(j)){
                    changed += alphabet.charAt((j-rotation+alphabet.length())%alphabet.length());
                }
            }
        }
        return changed;
    }
    
}
