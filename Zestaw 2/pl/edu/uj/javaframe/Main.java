package pl.edu.uj.javaframe;
import java.util.HashSet;

import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        MyDataFrame df = new MyDataFrame(new Class[] {MyImaginaryDouble.class, Int.class}, new String[] {"kol1","kol2"});
        df.addRow(new String[]{"12i3","23"});
        df.addRow(new String[]{"1244i4","23"});
        df.addRow(new String[]{"1244i6","2553"});
        df.addRow(new String[]{"12i9","2300"});
        df.print(); //wypisujemy tabelkę

//        MyImaginaryDouble im1 = (MyImaginaryDouble) new MyImaginaryDouble().create("12i3");
//        MyImaginaryDouble im2 = (MyImaginaryDouble) new MyImaginaryDouble().create("5i3");
//        MyImaginaryDouble im3 = (MyImaginaryDouble) new MyImaginaryDouble().create("5");
//        MyDouble re = (MyDouble) new MyDouble().create("5");
//
//        im1.print();
//        System.out.println();
//        im2.print();
//        System.out.println();
//        re.add(im2).print();
//        System.out.println();
//        System.out.println("------------------------------");
//        df.print();

        // test do zadania 2:
        System.out.println("------------------------------");
        MyImaginaryInt imgInt = new MyImaginaryInt();
        Int i = new Int();
        imgInt = (MyImaginaryInt) imgInt.create("12i4").add(i.create("10"));
        System.out.println(imgInt.toString());

        i = (Int) i.create("10").add(imgInt.create("12i4"));
        System.out.println(i.value.toString());

        imgInt = (MyImaginaryInt) (imgInt.create("12i4")).add(imgInt.create("10i10"));
        System.out.println(imgInt.toString());

    }
}