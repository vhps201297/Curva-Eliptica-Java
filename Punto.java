package com.proyecto.discretas.cerradura2;

public class Punto {
    private long x;
    private long y;

    public Punto(long x, long y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(long x){this.x=x;}
    public void setY(long y){this.y=y;}
    public long getX(){return this.x;}
    public long getY(){return this.y;}

    public String toString() {
        return "(" + this.x + "," + this.y + ")" + "\n";
    }
}
