package org.example;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized void depositar(double monto) {
        saldo += monto;
        System.out.println(Thread.currentThread().getName() + " depositó: " + monto + " - Saldo actual: " + saldo);
    }

    public synchronized void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo actual: " + saldo + ", Monto a retirar: " + monto);
        }
        saldo -= monto;
        System.out.println(Thread.currentThread().getName() + " retiró: " + monto + " - Saldo actual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
