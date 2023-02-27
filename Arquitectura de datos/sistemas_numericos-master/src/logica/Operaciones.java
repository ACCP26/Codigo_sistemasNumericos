/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Arrays;

/**
 *
 * @author Vinni
 */
public class Operaciones {

    int conversion = 0, numero = 0, i = 0, aux;
    String cadena = "", conversion2 = "";
    char digitosH[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    StringBuilder cadena_final = new StringBuilder();

    public String convertirDecimalBinario(String valor) {

        numero = Integer.parseInt(valor);
        do {
            conversion = numero % 2;

            numero = numero / 2;

            cadena_final.insert(0, String.valueOf(conversion));

        } while (numero != 0);

        return cadena_final.toString();
    }

    public String convertirDecimalHexadecimal(String valor) {

        numero = Integer.parseInt(valor);
        do {
            conversion = numero % 16;

            numero = numero / 16;

            cadena = digitosH[conversion] + cadena;

            i++;
        } while (numero != 0);

        return cadena;
    }

    public String convertirDecimalOctal(String valor) {

        numero = Integer.parseInt(valor);
        do {
            conversion = numero % 8;

            numero = numero / 8;

            cadena_final.insert(0, String.valueOf(conversion));

        } while (numero != 0);

        return cadena_final.toString();
    }

    public String convertirBinarioDecimal(String valor) {

        cadena = valor;
        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);
                conversion2 = String.valueOf(numero);
            }
        }
        return conversion2;
    }

    public String convertirBinarioHexadecimal(String valor) {

        cadena = valor;
        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);
            }
        }
        cadena = "";
        do {
            conversion = numero % 16;

            numero = numero / 16;

            cadena = digitosH[conversion] + cadena;

        } while (numero != 0);

        return cadena;
    }

    public String convertirBinarioOctal(String valor) {

        cadena = valor;
        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);
            }
        }

        do {
            conversion = numero % 8;

            numero = numero / 8;

            cadena_final.insert(0, String.valueOf(conversion));

        } while (numero != 0);

        return cadena_final.toString();
    }

    public String convertirHexadecimalBinario(String valor) {

        int k = 0;
        cadena = valor;

        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            conversion += numero * Math.pow(16, k);
            k++;
        }

        int decimal_final = (int) conversion;
        do {

            aux = decimal_final % 2;

            decimal_final = decimal_final / 2;

            cadena_final.insert(0, String.valueOf(aux));

        } while (decimal_final != 0);

        return cadena_final.toString();
    }

    public String convertirHexadecimalDecimal(String valor) {

        int j = 0;
        cadena = valor;
        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            conversion += numero * Math.pow(16, j);
            j++;
        }
        conversion2 = String.valueOf(conversion);
        return conversion2;
    }

    public String convertirHexadecimalOctal(String valor) {

        int j = 0;
        cadena = valor;
        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            conversion += numero * Math.pow(16, j);
            j++;
        }
        
        do {
            aux = conversion % 8;

            conversion = conversion / 8;

            cadena_final.insert(0, String.valueOf(aux));

        } while (conversion != 0);

        return cadena_final.toString();
    }

    public String convertirOctalBinario(String valor) {
        
        numero = Integer.parseInt(valor);
        
        while (numero != 0) {

            conversion += (numero % 10) * Math.pow(8, i);

            i++;

            numero /= 10;
        }
        
        do {
            aux = conversion % 2;

            conversion = conversion / 2;

            cadena_final.insert(0, String.valueOf(aux));

        } while (conversion != 0);

        return cadena_final.toString();
        
    }

    public String convertirOctalDecimal(String valor) {
        
        numero = Integer.parseInt(valor);
        
        while (numero != 0) {

            conversion += (numero % 10) * Math.pow(8, i);

            i++;

            numero /= 10;
        }
        
        cadena = String.valueOf(conversion);
        return cadena;
    }

    public String convertirOctalHexadecimal(String valor) {
        
        numero = Integer.parseInt(valor);
        
        while (numero != 0) {

            conversion += (numero % 10) * Math.pow(8, i);

            i++;

            numero /= 10;
        }
        
        do {
            aux = conversion % 16;

            conversion = conversion / 16;

            cadena = digitosH[aux] + cadena;

            i++;
        } while (conversion != 0);
        return cadena;
    }

    public static int valorHexadecimal(char caracter) {
        switch (caracter) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return Integer.parseInt(String.valueOf(caracter));
        }
    }

}
