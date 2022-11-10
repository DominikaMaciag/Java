package pl.edu.uj.javaframe;

import java.util.ArrayList;

public class MyDataFrame extends DataFrame{
    public MyDataFrame(Class<? extends Value>[] types, String[] vals) {
        super(types, vals);
    }

    public void print(){
        for(int i=0; i<this.columns.toArray().length; i++){
            System.out.print(this.columns.get(i).name+"      ");
        }
        int maxsize = 0;
        //szukamy najwiekszej dlugosci series
        for(int i=0; i<this.columns.toArray().length; i++){
            ArrayList<Value> ourvalues = this.columns.get(i).values;
            int ourvaluessize = ourvalues.size();
            if (ourvaluessize > maxsize) maxsize = ourvaluessize;
        }

        System.out.println("");
        for(int i=0; i<maxsize; i++){
            for(int j=0; j<this.columns.toArray().length; j++){
                if (this.columns.get(j).values.size()>i){
                    System.out.print(this.columns.get(j).values.get(i).toString() + "     ");
                }
            }
            System.out.println("");
        }
    }
}
