// Zmodyfikuj klasę Adder w taki sposób aby możliwe było dodanie do siebie dwóch serii danych (Series), 
// element po elemencie


public class Adder implements Applayable
{
    private final String toAdd;
    public Adder(String toAdd){
        this.toAdd = toAdd;
    }
    @Override
    public void apply(Series s) {
        for(Value v: s.values){
            Int nv = (Int)new Int().create(toAdd);
        }
    }
}
