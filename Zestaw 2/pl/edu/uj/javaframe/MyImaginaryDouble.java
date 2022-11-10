package pl.edu.uj.javaframe;

public class MyImaginaryDouble extends MyDouble{
    public double urojona;
    @Override
    public Value create(String val){
        int i;
        MyImaginaryDouble v = new MyImaginaryDouble();
        String pomocniczy = new String();
        for (i=0;i< val.length(); i++){                // część rzeczywista
            if(val.charAt(i)!='i'){
               pomocniczy += val.charAt(i);
               // System.out.println("----> " + i + " " + pomocniczy );
            }
            else{
                break;
            }
        }
        v.value = Double.parseDouble(pomocniczy);
        pomocniczy = "";
        for (i=i+1; i<=val.length()-1; i++){        // część urojona
            pomocniczy += val.charAt(i);
            // System.out.println("---- >" + pomocniczy );
        }
        v.urojona = Double.parseDouble(pomocniczy);
        return v;
    }

    public Value add(Value v){
        MyImaginaryDouble result  = new MyImaginaryDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());
        result.urojona = this.urojona;
        //System.out.println("add wykonany");
        if(v instanceof MyImaginaryInt ){
            result.urojona+= (double)((MyImaginaryInt) v).urojona;
        }
        if(v instanceof MyImaginaryDouble ){
            result.urojona+= ((MyImaginaryDouble) v).urojona;
        }
        return result;
    }

    @Override
    public String toString(){
        String pomocniczy = new String();
        pomocniczy += Double.toString((double)this.value);
        pomocniczy += "i";
        pomocniczy += Double.toString(this.urojona);
        return pomocniczy;
    }
}
