// Zmodyfikuj klasę Adder w taki sposób aby możliwe było dodanie do siebie dwóch serii danych (Series), 
// element po elemencie


public class Adder implements Applayable
{
    private final Series toAdd;
    public Adder(Series toAdd){
        this.toAdd = toAdd;
    }
    @Override
    public void apply(Series s) {
        for(int i=0; i<s.values.size(); i++){
            s.values.set(i,s.values.get(i).add(toAdd.values.get(i))); 
        }
    }
}
