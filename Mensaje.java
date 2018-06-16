package com.proyecto.discretas.cerradura2;

public class Mensaje {

    public static Punto Codificar(char letra, long h, long a, long b, long p) {
        int c = letra - 31, i = 1;
        long y = -1;
        long x;


        do
        {
            x = c * h + i;
            y = ((x * x * x) + a * x + b) % p;
            y = ModularArith.SqrtMod(x, p);
            i++;
        } while (y == -1);
        return new Punto(x, y);

    }
    public static char Decodifica(Punto p, long h) {
        char c;
        long M;
        M = (p.getX() - 1) / h;
        c = (char)(M);
        return c;
    }
}
