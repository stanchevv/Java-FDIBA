package geometry;

public class QuatrefoilDemo {

    public static void main(String[] args) {

        Quatrefoil quatrefoil1 = new Quatrefoil();
        Quatrefoil quatrefoil2 = new Quatrefoil(new Point(1,2),2,3);
        Quatrefoil quatrefoil3 = new Quatrefoil(quatrefoil2);
        Quatrefoil quatrefoil4 = new Quatrefoil();

        quatrefoil4.initialize();

        System.out.println("Quatrefoil 2 = Quatrefoil 1: "+quatrefoil2.equal(quatrefoil1));
        System.out.println("Quatrefoil 2 = Quatrefoil 3: "+quatrefoil2.equal(quatrefoil3));
        quatrefoil1.print();
        quatrefoil2.print();
        quatrefoil3.print();
        quatrefoil4.print();
    }
}

// Ausgabe

//        Eingabe x: 4
//        Eingabe y: 5
//        Width:
//        1
//        Height:
//        2
//        Quatrefoil 2 = Quatrefoil 1: false
//        Quatrefoil 2 = Quatrefoil 3: true
//        Quatrefoil: (0.0,0.0)-{1.0,1.0}, regular, U=6.283185307179586, F=2.5707963267948966
//        Quatrefoil: (1.0,2.0)-{2.0,3.0}, irregular, U=15.707963267948966, F=16.21017612416683
//        Quatrefoil: (1.0,2.0)-{2.0,3.0}, irregular, U=15.707963267948966, F=16.21017612416683
//        Quatrefoil: (4.0,5.0)-{1.0,2.0}, irregular, U=9.42477796076938, F=5.926990816987241

//        Process finished with exit code 0
