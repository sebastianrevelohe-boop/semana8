package org.example;

public class Cajero implements Runnable {
    private CuentaBancaria cuenta;
    private double montoARetirar;

    public Cajero(CuentaBancaria cuenta, double montoARetirar) {
        this.cuenta = cuenta;
        this.montoARetirar = montoARetirar;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random() * 1000)); // Simula un tiempo aleatorio de procesamiento
            cuenta.retirar(montoARetirar);
        } catch (SaldoInsuficienteException e) {
            System.out.println(Thread.currentThread().getName() + ": Error - " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " fue interrumpido.");
        }
    }
}
