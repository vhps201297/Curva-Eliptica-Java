package com.proyecto.discretas.cerradura2;

public class ModularArith {
    /*
     * Método MCD:
     * Obtiene el Máxmimo Común Divisor de dos números.
     * Regresa el Máximo Común Divisor.
     */
    public static long MCD(long a, long b) {
        long r;
        while (b !=0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long InvMod(long a, long b) {

        if (a < 0)
        {
            a = a + b;
        }
        long c1 = 1;
        long c2 = -(b/a);
        long t1 = 0;
        long t2 = 1;
        long r = b % a;
        long x = a, y = r, c;
        while (r != 0)
        {
            c = x / y;
            r = x % y;
            c1 *= -c;
            c2 *= -c;
            c1 += t1;
            c2 += t2;
            t1 = -(c1 - t1) / c;
            t2 = -(c2 - t2) / c;
            x = y;
            y = r;
        }
        if (x == 1)
        {
            if (t2 < 0)
            {
                return (t2 + b);
            }
            return t2;
        }
        else
        {
            return 0;
        }


    }

    public static long PowMod(long a, long x, long m) {
        long res = 1;
        a = a % m;
        while (x > 0)
        {
            if ((x & 1) == 1)
            {
                res = (res * a) % m;
            }
            x = x / 2;
            a = (a * a) % m;
        }
        return res;
    }

    public static long SqrtMod(long n, long p) {
        long q = p - 1;
        long s = 0;
        long r;
        while (q % 2 == 0)
        {
            q /= 2;
            s++;
        }

        if (s == 1)
        {
            r = PowMod(n, (p + 1) / 4, p);

            if (PowMod(r, 2, p) == n % p)
            {
                return r;
            }
            return 0;
        }

        long z;
        for (z = 2; z < p; z++)
        {
            if (p - 1 == PowMod(z, (p - 1) / 2, p))
            {
                break;
            }
        }

        long c = PowMod(z, q, p);
        r = PowMod(n, (q + 1) / 2, p);
        long t = PowMod(n, q, p);
        long m = s;
        long t2 = 0;
        long i;
        long b;
        while ((t - 1) % p != 0)
        {
            t2 = PowMod(t, 2, p);
            for (i = 1; i < m; i++)
            {
                if (((t2 - 1) % p) == 0)
                {
                    break;
                }
                t2 = PowMod(t2, 2, p);
            }

            b = PowMod(c,(long) Math.pow(2, m - i - 1), p);
            r = (r * b) % p;
            c = PowMod(b, 2, p);
            t = (t * c) % p;
            m = i;
        }
        return r;
    }
}
