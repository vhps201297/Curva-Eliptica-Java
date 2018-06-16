package com.proyecto.discretas.cerradura2;

public class Sistema {
    private long privateKey=3149282;
    private Punto publicKey;
    private Curva C;
    private Punto G;
    private long k=13579;

    public Sistema(Curva c, Punto g)
    {
        this.C = c;
        this.G = g;
        calcPublicKey();
    }

    public Punto getPublicKey() { return this.publicKey; }
    public Curva getC(){ return this.C; }
    public Punto getG() {return this.G; }
    public void setC(Curva C){this.C=C;}
    public void setG(Punto G){this.G=G;}

    private void calcPublicKey() {
        this.publicKey = Aritmetica.MultEyP(this.privateKey, this.G, this.C.getA(), this.C.getP());
    }
    public char desEncriptar(Punto M, Punto N) {
        Punto P, Mm;
        char c;
        Mm = Aritmetica.MultEyP(this.privateKey, M, this.C.getA(), this.C.getP());
        P = Aritmetica.RestaPyQ(N, Mm, this.C.getP());
        c = Mensaje.Decodifica(P, this.C.getH());
        return c;
    }
    public Punto encriptar(Punto M,Punto publicKeyB) {
        Punto N;
        Punto Aux;
        Aux = Aritmetica.MultEyP(this.k,publicKeyB,this.C.getA(),this.C.getP());
        N = Aritmetica.SumaPyQ(M,Aux,this.C.getP());
        return N;
    }
    public Punto getkG() {
        return Aritmetica.MultEyP(this.k,this.G,this.C.getA(),this.C.getP());
    }
}
