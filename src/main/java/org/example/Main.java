package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cuenta = new CuentaBancaria(1000.0); // Saldo inicial de 1000

        // Crear tres hilos de cajeros intentando retirar 500 cada uno
        Thread cajero1 = new Thread(new Cajero(cuenta, 500), "Cajero 1");
        Thread cajero2 = new Thread(new Cajero(cuenta, 500), "Cajero 2");
        Thread cajero3 = new Thread(new Cajero(cuenta, 500), "Cajero 3");

        System.out.println("Saldo inicial: " + cuenta.getSaldo());

        // Iniciar los hilos
        cajero1.start();
        cajero2.start();
        cajero3.start();

        // Esperar a que todos los hilos terminen
        cajero1.join();
        cajero2.join();
        cajero3.join();

        System.out.println("\nSaldo final: " + cuenta.getSaldo());
    }
}