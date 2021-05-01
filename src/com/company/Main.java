package com.company;
import java.util.Scanner;
public class Main {

    public static double medicinasobrantew(int cantidaddedias, double cantidadmedicina){
        double medicinasobrante;
        while(cantidaddedias > 0){
            cantidadmedicina = cantidadmedicina - (cantidadmedicina * 0.2);
            cantidaddedias--;
        }
        medicinasobrante = cantidadmedicina;
        return medicinasobrante;
    }
    public static double medicinasobranterecursivo(int cantidaddedias, double cantidadmedicina) {

        if(cantidaddedias<=0)
        {
            return cantidadmedicina;
        }
        else
        {
            cantidadmedicina = cantidadmedicina - (cantidadmedicina * 0.2);
            return medicinasobranterecursivo(cantidaddedias-1, cantidadmedicina);
        }
    }
    public static int diaseneliminar(double cantidamedicina, double porcentajeaeliminar){
        double basedivisorporcentaje = 100;
        double cantidadmedicinarestante = cantidamedicina*(1-(porcentajeaeliminar/basedivisorporcentaje));
        int contadordia=0;
        while(cantidamedicina>cantidadmedicinarestante){
            cantidamedicina = cantidamedicina - (cantidamedicina * 0.2);
            contadordia++;
        }
        return  contadordia;
    }
    public static int diaseneliminarRecursive(double cantidamedicina, double porcentajeaeliminar){
        double basedivisorporcentaje = 100;
        double cantidadmedicinarestante = cantidamedicina*(1-(porcentajeaeliminar/basedivisorporcentaje));
        return recursion(0, cantidamedicina, cantidadmedicinarestante);
    }
    private static int recursion(int contadordia, double cantidamedicina, double cantidadmedicinarestante) {
        if(cantidamedicina<=cantidadmedicinarestante){
            return contadordia;
        }
        return recursion(++contadordia, cantidamedicina - (cantidamedicina * 0.2), cantidadmedicinarestante) ;
    }


    public static void main(String[] args) {

        Scanner cantidaddiasObj = new Scanner(System.in);
        Scanner cantidadmedicinaObj01 = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de días:");
        int cantidaddediasvar = Integer.parseInt(cantidaddiasObj.nextLine());
        System.out.println("Ingrese la cantidad de medicina:");
        double cantidaddemedicinavar01 = Double.parseDouble(cantidadmedicinaObj01.nextLine());
        System.out.println("Al día "+cantidaddediasvar+" aún queda "+medicinasobranterecursivo(cantidaddediasvar,cantidaddemedicinavar01)+" de medicina en tu cuerpo");
        System.out.println("Al día "+cantidaddediasvar+" aún queda "+medicinasobrantew(cantidaddediasvar,cantidaddemedicinavar01)+" de medicina en tu cuerpo");

        Scanner cantidadmedicinaObj02 = new Scanner(System.in);
        Scanner cantidadporcentajeObj = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de medicina:");
        double cantidaddemedicinavar02 = Double.parseDouble(cantidadmedicinaObj02.nextLine());
        System.out.println("Ingrese la del porcentaje a eliminar:");
        double cantidadporcentajevar = Double.parseDouble(cantidadporcentajeObj.nextLine());
        System.out.println("Para eliminar el "+cantidadporcentajevar+" % necesita "+diaseneliminar(cantidaddemedicinavar02,cantidadporcentajevar)+" días");
        System.out.println("Para eliminar el "+cantidadporcentajevar+" % necesita "+diaseneliminarRecursive(cantidaddemedicinavar02,cantidadporcentajevar)+" días");

    }
}
