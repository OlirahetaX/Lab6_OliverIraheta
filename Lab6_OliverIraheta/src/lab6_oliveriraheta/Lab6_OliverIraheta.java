package lab6_oliveriraheta;

import java.util.Scanner;
import java.util.Random;

public class Lab6_OliverIraheta {

    public static Random ra = new Random();
    public static Scanner vini = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        //try{
        boolean x = true;
        while (x == true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Bienvenid@ a Laboratorio 6");
            System.out.println("1. El juego de la vida       2.  Pierda, papel o ...     3. Blink-182");
            System.out.println("¿Que juego quieres jugar?(4. Salir)");
            int opc = vini.nextInt();
            x = _switch(opc);
        }
        //}catch(Exception e){System.out.println("Ocurrio un error");}
    }

    public static boolean _switch(int opc) {
        boolean x = true;
        switch (opc) {
            case 1:
                //vida();
                break;
            case 2:
                piedra();
                break;
            case 3:
                blink();
                break;
            case 4:
                System.out.println("Adios!");
                x = false;
                break;
            default:
                System.out.println("Opcion no disponible");
        }

        return x;
    }

    public static void blink() {
        System.out.println("Ingrese numero de filas");
        int filas = vini.nextInt();
        System.out.println("Ingrese numero de columnas");
        int columnas = vini.nextInt();
        imprimirmatriz(llenarmatriz(generarmatriz(filas, columnas)));
    }

    public static int[][] generarmatriz(int x, int y) {
        int[][] matriz = new int[x][y];
        return matriz;
    }

    public static int[][] llenarmatriz(int[][] matriz) {
        int[][] matriz1 = matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ra.nextInt((122 - 97) + 1) + 97;
            }
        }
        return matriz1;
    }

    public static void imprimirmatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {//Fila 
            for (int j = 0; j < matriz[i].length; j++) {//Columna
                System.out.print(" " + matriz[i][j] + " -");
            }
            System.out.println("");
        }
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {//Fila 
            for (int j = 0; j < matriz[i].length; j++) {//Columna
                int a = matriz[i][j];
                char s = (char) a;
                System.out.print(" " + s + " -");
            }
            System.out.println("");
        }
    }

    public static void piedra() {
        boolean ney = false;
        do {
            int[][] matrix = new int[5][5];
            matrix = llenarmatrix(matrix);
            System.out.println("OPCIONES:");
            System.out.println("0. Scissors  1. Paper    2. Rock   3. Lizard    4. Spock");
            System.out.print("Elija que quiere usar:");
            int opc = vini.nextInt();
            System.out.println("Usted eligio: " + opcion(opc));
            int maquina = ra.nextInt((4 - 0) + 1) + 0;
            System.out.println("La maquina eligio: " + opcion(maquina));
            decisionmatrix(matrix, opc, maquina);
        } while (ney == true);
    }

    public static int[][] llenarmatrix(int[][] matrix) {
        int[][] matrix1 = matrix;
        matrix1[0][1] = 0;
        matrix1[0][2] = 2;
        matrix1[1][2] = 1;
        matrix1[0][3] = 0;
        matrix1[1][3] = 3;
        matrix1[2][3] = 2;
        matrix1[0][4] = 4;
        matrix1[1][4] = 1;
        matrix1[2][4] = 4;
        matrix1[3][4] = 3;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                if (i == j) {
                    matrix1[i][j] = 5;
                }
                matrix1[j][i] = matrix1[i][j];
            }
        }
        return matrix1;
    }

    public static boolean decisionmatrix(int[][] matrix, int opc, int maquina) {
        boolean ney = false;
        int[][] matriX = matrix;
        int gan = matriX[opc][maquina];
        System.out.println();
        if (gan == 5) {
            System.out.println("Empate!");
            ney = true;
        } else if (gan == opc) {
            System.out.println("FELICIDADES USTED HA GANADO!!!");
        } else {
            System.out.println("La maquina gano :(");
        }

        return ney;
    }

    public static String opcion(int opc) {
        String opcion = "";
        if (opc == 0) {
            opcion = "Scissors";
        } else if (opc == 1) {
            opcion = "Paper";
        } else if (opc == 2) {
            opcion = "Rock";
        } else if (opc == 3) {
            opcion = "Lizard";
        } else if (opc == 4) {
            opcion = "Spock";
        }
        return opcion;
    }
}
