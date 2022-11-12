public class Polibiusz implements Algorithm {
        public char polybiusSquare[][] = { 
        {'A', 'B', 'C', 'D', 'E'},
        {'F', 'G', 'H', 'I', 'K'},
        {'L', 'M', 'N', 'O', 'P'},
        {'Q', 'R', 'S', 'T', 'U'},
        {'V', 'W', 'X', 'Y', 'Z'}
    };

    int numberOfRows = polybiusSquare[0].length;
    int numberOfColumns = polybiusSquare.length;

    @Override
    public String crypt(String inputWord) {
        String str = inputWord.toUpperCase();
        String output = "";

        for(int i=0; i< inputWord.length(); i++){
            if(str.charAt(i)<'A' | str.charAt(i)>'Z'){
                output += str.charAt(i);
            }
            for(int j=0; j<numberOfRows; j++){ 
                for(int k=0; k<numberOfColumns; k++){
                    if(str.charAt(i)==polybiusSquare[j][k]){
                        output += (char)j+1;
                        output +=  + (char)k+1;
                    }
                }
            }
        }
        return output;
    }
    
    @Override
    public String decrypt(String inputWord) {
        String output = "";
        for(int i=0; i<inputWord.length(); i++){
            if(inputWord.charAt(i)<'0' | inputWord.charAt(i)>'9') { 
                output += inputWord.charAt(i);
            }
            else {
                int row = inputWord.charAt(i)- '0' - 1;
                int col = inputWord.charAt(i+1)- '0' - 1;
                output += polybiusSquare[row][col]; 
                i+=1;
            }
        }
        return output;
    }
}
