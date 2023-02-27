/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Operaciones {

    Scanner entrada = new Scanner(System.in);
    int opcion;
    int numero = 0, binario = 0, i = 0, hexa = 0, octal = 0;
    double decimal = 0, hexa2 = 0;
    int[] numero_final = new int[100000];
    double[] numero_binario = new double[10000];
    char digitosH[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    String cadena, hexa_final = "";

    public void menu() {

        do {
            System.out.println("\n-------------------------------------------------");
            System.out.println("\n\tCONVERSOR DE SISTEMAS NUMERICOS");
            System.out.println("Digite una opcion: ");
            System.out.println("1.Decimal a binario\n2.Decimal a hexadecimal\n3.Decimal a Octal\n4.Binario a Decimal"
                    + "\n5.Binario a hexadecimal\n6.Binario a octal\n7.Hexadecimal a decimal\n8.Hexadecimal a binario"
                    + "\n9.Hexadecimal a octal\n10.Octal a decimal\n11.Octal a binario\n12.Octal a hexadecimal\n13.Obtener un decimal\n14.Salir");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    decimalABinario();
                    break;

                case 2:
                    decimalAHexa();
                    break;
                case 3:
                    decimalAOctal();
                    break;
                case 4:
                    binarioADecimal();
                    break;
                case 5:
                    binarioAHexa();
                    break;
                case 6:
                    binarioAOctal();
                    break;
                case 7:
                    hexaADecimal();
                    break;
                case 8:
                    hexaABinario();
                    break;
                case 9:
                    hexaAOctal();
                    break;
                case 10:
                    octalADecimal();
                    break;
                case 11:
                    octalABinario();
                    break;
                case 12:
                    octalAHexa();
                    break;
                case 13:
                    decimal();
                    break;
                case 14:
                    System.exit(0);
                    break;

                default:
                    System.out.println("OPCION NO VALIDA");
                    break;
            }

        } while (opcion != 4);

    }

    public void decimalABinario() {

        System.out.println("Digite un numero decimal: ");
        numero = entrada.nextInt();
        entrada.nextLine();

        do {
            binario = numero % 2;

            numero = numero / 2;

            numero_final[i] = binario;

            i++;

        } while (numero != 0);
        System.out.print(i);
        System.out.print("Numero binario -->");

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(numero_final[j]);
        }

        System.out.println();
        i = 0;

    }

    public void binarioADecimal() {

        System.out.println("Digite un numero binario: ");
        cadena = entrada.next();

        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);
            } else if (cadena.charAt(i) != '0') {

                System.out.println("ta mal");
            }
        }
        System.out.println("Numero decimal -->" + numero);
        numero = 0;
        i = 0;
    }

    public void decimalAHexa() {

        System.out.println("Digite un numero decimal: ");
        numero = entrada.nextInt();
        entrada.nextLine();

        do {
            hexa = numero % 16;

            numero = numero / 16;

            hexa_final = digitosH[hexa] + hexa_final;

            i++;
        } while (numero != 0);

        System.out.print("Numero hexadecimal -->" + hexa_final);

        System.out.println();
        hexa_final = "";
        i = 0;
    }

    public void decimalAOctal() {

        System.out.println("Digite un numero decimal: ");
        numero = entrada.nextInt();
        entrada.nextLine();

        do {
            octal = numero % 8;

            numero = numero / 8;

            numero_final[i] = octal;

            i++;

        } while (numero != 0);

        System.out.print("Numero octal -->");

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(numero_final[j]);
        }

        System.out.println();
        i = 0;
    }

    public void binarioAHexa() {

        System.out.println("Digite un numero binario: ");
        cadena = entrada.next();

        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);
            } else if (cadena.charAt(i) != '0') {

                System.out.println("ta mal");
            }
        }

        do {
            hexa = numero % 16;

            numero = numero / 16;

            hexa_final = digitosH[hexa] + hexa_final;

            i++;
        } while (numero != 0);

        System.out.print("Numero hexadecimal -->" + hexa_final);

        System.out.println();
        hexa_final = "";
        numero = 0;
        i = 0;
    }

    public void binarioAOctal() {

        System.out.println("Digite un numero binario: ");
        cadena = entrada.next();

        for (i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == '1') {

                numero += Math.pow(2, cadena.length() - 1 - i);

            } else if (cadena.charAt(i) != '0') {

                System.out.println("ta mal");
            }
        }
        i = 0;
        do {
            octal = numero % 8;

            numero = numero / 8;

            numero_final[i] = octal;

            i++;

        } while (numero != 0);

        System.out.print("Numero octal -->");

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(numero_final[j]);
        }

        System.out.println();
        i = 0;

    }

    public void hexaADecimal() {

        System.out.println("Digite un numero hexadecimal: ");
        cadena = entrada.next();
        int j = 0;
        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            decimal += numero * Math.pow(16, j);
            j++;
        }

        System.out.print("Numero decimal -->" + convertir(decimal));
        numero = 0;
        decimal = 0;
        System.out.println();
    }

    public void hexaABinario() {
        System.out.println("Digite un numero hexadecimal: ");
        cadena = entrada.next();
        int k = 0;
        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            decimal += numero * Math.pow(16, k);
            k++;
        }

        int p = 0;
        int decimal_final = (int) decimal;
        do {

            hexa = decimal_final % 2;

            decimal_final = decimal_final / 2;

            numero_final[p] = hexa;

            p++;

        } while (decimal_final != 0);

        System.out.print("Numero binario -->");

        for (int j = p - 1; j >= 0; j--) {
            System.out.print(convertir(numero_final[j]));
        }

        System.out.println();
        i = 0;
        numero = 0;
        decimal = 0;
    }

    public void hexaAOctal() {
        System.out.println("Digite un numero hexadecimal: ");
        cadena = entrada.next();
        int k = 0;
        for (i = cadena.length() - 1; i >= 0; i--) {

            numero = valorHexadecimal(cadena.charAt(i));
            decimal += numero * Math.pow(16, k);
            k++;
        }

        int p = 0;
        int decimal_final = (int) decimal;

        do {
            octal = decimal_final % 8;

            decimal_final = decimal_final / 8;

            numero_final[p] = octal;

            p++;

        } while (decimal_final != 0);
        System.out.print(p);
        System.out.print("Numero octal -->");

        for (int j = p - 1; j >= 0; j--) {
            System.out.print(numero_final[j]);
        }

        System.out.println();
        i = 0;
    }

    public void octalADecimal() {

        System.out.println("Digite un numero octal: ");
        octal = entrada.nextInt();
        entrada.nextLine();

        while (octal != 0) {

            numero += (octal % 10) * Math.pow(8, i);

            i++;

            octal /= 10;
        }
        
        System.out.println("El numero decimal es---> " + numero);
        octal=0;
        i=0;
        numero=0;
    }
    
    public void octalABinario(){
        
        System.out.println("Digite un numero octal: ");
        octal = entrada.nextInt();
        entrada.nextLine();

        while (octal != 0) {

            numero += (octal % 10) * Math.pow(8, i);

            i++;

            octal /= 10;
        }
        i = 0;
        
        do {
            
            binario = numero % 2;

            numero = numero / 2;

            numero_final[i] = binario;

            i++;

        } while (numero != 0);
        
        System.out.print("Numero binario -->");

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(numero_final[j]);
        }

        System.out.println();
        i = 0;
        
    }
    
    public void octalAHexa(){
        
        System.out.println("Digite un numero octal: ");
        octal = entrada.nextInt();
        entrada.nextLine();

        while (octal != 0) {

            numero += (octal % 10) * Math.pow(8, i);

            i++;

            octal /= 10;
        }
        
        i=0;
        do {
            hexa = numero % 16;

            numero = numero / 16;

            hexa_final = digitosH[hexa] + hexa_final;

            i++;
        } while (numero != 0);

        System.out.print("Numero hexadecimal -->" + hexa_final);

        System.out.println();
        hexa_final = "";
        i = 0;
    }

    public void decimal() {

        do {
            System.out.println("Digite un numero decimal (0-9): ");
            numero = entrada.nextInt();
            entrada.nextLine();

            if (numero >= 0 && numero <= 9) {
                System.out.println("Digite como desea representar la cifra:\n\t|CM|DM|UM|C|D|U| ");
                cadena = entrada.nextLine().toUpperCase();

                switch (cadena) {

                    case ("CM"):

                        decimal = numero * Math.pow(10, 5);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^5");
                        break;

                    case ("DM"):

                        decimal = numero * Math.pow(10, 4);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^4");
                        break;

                    case ("UM"):

                        decimal = numero * Math.pow(10, 3);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^3");
                        break;

                    case ("C"):

                        decimal = numero * Math.pow(10, 2);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^2");
                        break;

                    case ("D"):

                        decimal = numero * Math.pow(10, 1);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^1");
                        break;

                    case ("U"):

                        decimal = numero * Math.pow(10, 0);
                        System.out.println("El proceso fue:\n\t " + convertir(decimal) + " = " + numero + "* 10^0");
                        break;
                }

            } else {
                System.out.println("ERROR");
            }
        } while (numero < 0 || numero > 9);
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

    public String convertir(double d) {
        NumberFormat nf = new DecimalFormat("##.###");
        return nf.format(d);
    }
    
    /*public boolean validarOctal(int octal){
        
        cadena = String.valueOf(octal);
        String digitosO = "0123457";
        char caracter;
        for(i = 0; i<cadena.length();i++){
            caracter = cadena.charAt(i);
            
            if (digitosO.indexOf(caracter) = -1){
                return false;
            }
        }return true;
    }*/

}
