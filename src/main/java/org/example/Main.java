package org.example;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Variables de entrada
        String nombre, destino;
        byte numeroPersonas;
        boolean seguro;
        DecimalFormat decimal=new DecimalFormat("#.##");

        //Constantes
        final float IMPUESTO = 0.12F;
        final float SEGURO_DE_VIAJE = 50000.0F;
        final float DESCUENTO_GRUPO_GRANDE = 0.08F;
        final float PRECIO_PERSONA = 150000.0F;

        //Variables de salida
        String  destinos[] = {"san andres", "santa marta", "bogota", "cartagena", "medellin"};
        float subtotal, total, totalConSeguro;
        UUID numeroReserva = UUID.randomUUID();



        System.out.println("Por favor Ingrese su nombre : ");
        nombre = sc.nextLine();
        System.out.println("Estos son los destinos que estan disponibles : ");
        for (String destinoViajes : destinos){
            System.out.println(destinoViajes);
        }
        System.out.println("Por favor ingrese el destino que esta en la lista :");
        destino = sc.nextLine();
        System.out.println("Por favor Ingrese el numero de personas que viajan : ");
        numeroPersonas = sc.nextByte();
        System.out.println("Desea adquirir el seguro de viaje? (true or false): ");
        seguro = sc.nextBoolean();

        //Operaciones
        subtotal = numeroPersonas * PRECIO_PERSONA;
        total = subtotal + (subtotal * IMPUESTO);
        totalConSeguro = total + (SEGURO_DE_VIAJE * numeroPersonas);


        System.out.println("El numero de reseva : " + numeroReserva + " Para la persona: " + nombre + " Fue Exitoso!!!!");
        System.out.println("El destino al cual esta perosna viaja es a : " + destino );
        System.out.println("El numero de boletos reservados es de : " + numeroPersonas);
        if(!seguro){
            if (numeroPersonas > 3){
                float totalGrupoGrande = total - (total * DESCUENTO_GRUPO_GRANDE);
                System.out.println("El numero de reserva " + numeroReserva + "Aplica descuento del 8% " + "\n" +
                        "Su subtotal es de " + subtotal + " y su total es de " + totalGrupoGrande + " Es un grupo grande y No aplica al seguro");
            }
            else{
                System.out.println("El numero de reserva " + numeroReserva + "Aplica descuento del 8% " + "\n" +
                        "Su subtotal es de " + subtotal + " y su total es de " + total + " No es un grupo grande y No aplica al seguro");
            }

        }
        else if (seguro) {
            if (numeroPersonas > 3){
                float totalGrupoGrande = totalConSeguro - (totalConSeguro * DESCUENTO_GRUPO_GRANDE) ;
                System.out.println("El numero de reserva " + numeroReserva + " Aplica descuento del 8% " + "\n" +
                        "Su subtotal es de " + subtotal + " y su total es de " + totalGrupoGrande + " Es un grupo grande y Aplica al seguro");
            }
            else{
                System.out.println("El numero de reserva " + numeroReserva + "Aplica descuento del 8% " + "\n" +
                        "Su subtotal es de " + subtotal + " y su total es de " + totalConSeguro + " No es un grupo grande pero Aplica al seguro");
            }
        }






        }
    }