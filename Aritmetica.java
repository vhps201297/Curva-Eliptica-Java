package com.proyecto.discretas.cerradura2;

public class Aritmetica {
    public static Punto MultEyP(long k, Punto P, long a, long p) {
        double c, d;
        int i, n;
        long t;

        c = Math.log10(k);
        d = Math.log10(2);
        n = (int)(c/d) + 1;
        int [] B=new int[n];

        //DectoBin
        i = n - 1;
        t = k;
        while (i > -1)
        {
            B[i] = (int)(t % 2);
            t = t / 2;
            i--;
        }
        //

        Punto Pc=new Punto(0,0);
        Punto R;
        R = SumaPyP(Pc, a, p);
        //Console.WriteLine(R.ToString() );
        for (i = 0; i < n; i++)
        {

            R = SumaPyP(R, a, p);
            if (B[i] == 1)
            {

                R = SumaPyQ(R, P, p);
                //R.Print();
            }
            else
            {

                System.out.println( R.toString());
            }

        }
        return R;

    }
    public static Punto SumaPyP(Punto P, long a, long p) {

        if (P.getX() == 0 && P.getY() == 0)
        {
            return P;
        }

        long l;
        long Rx;
        long Ry;
        l =( 3 * P.getX() * P.getX() + a);

        l = l * ModularArith.InvMod(2 * P.getY(), p );

        l = l%p;

        Rx = (l*l -2*P.getX()) % p;

        if (Rx < 0)
        {
            Rx = Rx + p;
        }

        Ry = (l*(P.getX() -Rx) -P.getY()) % p;

        if (Ry < 0)
        {
            Ry = Ry + p;
        }

        return new Punto(Rx, Ry);
    }

    public static Punto RestaPyQ(Punto P, Punto Q, long p) {
        long y;
        Punto R;
        y = p - Q.getY();
        Q.setY(y);
        R = SumaPyQ(P, Q, p);
        return R;
    }

    public static Punto SumaPyQ(Punto P, Punto Q, long p) {

        if (P.getX() == 0 && P.getY()== 0)
        {
            return Q;
        }
        long l;
        long Rx;
        long Ry;

        l = P.getY() - Q.getY();
        l = l * ModularArith.InvMod((P.getX()- Q.getX()), p);
        l = l % p;
        Rx = (l * l - P.getX()- Q.getX()) % p;

        if (Rx < 0)
        {
            Rx = Rx + p;
        }

        Ry = (l*(P.getX() - Rx) -P.getY()) % p;
        if (Ry < 0)
        {
            Ry = Ry + p;
        }
        return new Punto(Rx, Ry);
    }
}
