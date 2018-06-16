package com.proyecto.discretas.cerradura2;

public class Conversion {

        /*
         * Funcion que convierte un String a long long
         */

        public static long stringToLong(String s){

            return Long.parseLong(s);

        }
        /*
         * Funcion que convierte una cadena de caracteres a long long
         */
        public static long charToLong(char[] c) {
            String s=String.valueOf(c);

            return stringToLong(s);
        }
        /*
         * Convierte String a Punto
         */
        public static Punto stringToPunto(String s){
            int coma;
            String x,y;
            long X,Y;

            coma=s.indexOf(",");
            x=s.substring(1,coma);
            y=s.substring(coma+1,s.length()-1);

            X=stringToLong(x);
            Y=stringToLong(y);

            return new Punto(X,Y);
        }

}
