package pl.edu.uj.javaframe;

public class MyImaginaryInt extends Int{
    public Integer urojona = 0;
    @Override
    public Value create(String val){
        int i;
        MyImaginaryInt v = new MyImaginaryInt();
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
        v.value = Integer.parseInt(pomocniczy);
        pomocniczy = "";
        for (i=i+1; i<=val.length()-1; i++){        // część urojona
            pomocniczy += val.charAt(i);
            // System.out.println("---- >" + pomocniczy );
        }
        v.urojona = Integer.parseInt(pomocniczy);
        return v;
    }

    @Override
    public Value add(Value v){
        MyImaginaryInt result  = new MyImaginaryInt();
        result.value = (Integer)this.value + Integer.valueOf(v.value.toString());
        result.urojona = this.urojona;
        //System.out.println("add wykonany");
        if(v instanceof MyImaginaryInt ){
            result.urojona+= ((MyImaginaryInt) v).urojona;
        }
        if(v instanceof MyImaginaryDouble ){
            result.urojona+= (int)((MyImaginaryDouble) v).urojona;
        }
        return result;
    }

    @Override
    public String toString(){
        String pomocniczy = new String();
        pomocniczy += Integer.toString((int)this.value);
        pomocniczy += "i";
        pomocniczy += Integer.toString(this.urojona);
        return pomocniczy;
    }
}
