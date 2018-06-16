package com.proyecto.discretas.cerradura2;

public class Curva {

        //Numero Primo que define el Grupo
        private long p;
        //Parametros de la curva y^2 = x^3 +ax+b
        private long a;
        private long b;
        //Factor Espaciamiento H
        private long h;

        public long getA(){return this.a;}
        public long getB(){return this.b;}
        public long getP(){return this.p;}
        public long getH(){return this.h;}

        public Curva(long p, long a, long b, int M)
        {
            this.p = p;
            this.a = a;
            this.b = b;
            this.h = CalcH(p, M);
        }
        private long CalcH(long p, int n) {
            long h;
            long N = n;
            h = p / N;
            return h;

        }
}
