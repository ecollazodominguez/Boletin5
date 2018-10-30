package boletin5_1;

import javax.swing.JOptionPane;

/**
 * Control de cuentas bancarias y operaciones.
 * @author ecollazodominguez
 */
public class Conta {

    /**
     * Nombre de cliente.
     */
    private String nome;
    /**
     * Número de cuenta bancaria.
     */
    private String numConta;
    /**
     * Saldo de la cuenta bancaria.
     */
    private double saldo;

    public Conta() {

    }

    public Conta(String nome, String conta, double saldo) {
        this.nome = nome;
        this.numConta = conta;
        this.saldo = saldo;
    }
    /**
     * Se añade un nombre al cliente.
     * @param nome nombre del cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Se registra un número de cuenta al cliente.
     * @param numConta número de cuenta.
     */
    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }
    /**
     * Se registra un saldo de cuenta.
     * @param saldo saldo de cuenta.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Envia nombre del cliente
     * @return nombre del cliente.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Envia número de cuenta del cliente
     * @return número cuenta del cliente.
     */
    public String getNumConta() {
        return numConta;
    }
    /**
     * Envia saldo en la cuenta bancaria.
     * @return saldo en la cuenta bancaria.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Ingresa saldo a una cuenta bancaria.
     * @param dinero cantidad a ingresar.
     */
    public void ingresarSaldo(double dinero) {
        if (dinero <= 0) {
            JOptionPane.showMessageDialog(null, "No tienes dinero para ingresar.");
        } else if (saldo >= dinero) {
            saldo += dinero;
        }
        
    }
    /**
     * Retira saldo a una cuenta bancaria.
     * @param dinero cantidad a retirar.
     */
    public void retirarSaldo(double dinero) {
        if (dinero <= 0) {
            JOptionPane.showMessageDialog(null, "No tienes dinero para retirar.");
        } else if (saldo >= dinero) {
            saldo -= dinero;
        }
    }
    /**
     * Muestra la información del cliente.
     */
    public void amosarDatos() {
        System.out.println("\nNome: " + nome + "\nConta: " + numConta + "\nSaldo: " + saldo);
    }
    /**
     * Transfiere saldo de una cuenta a otra.
     * @param destino cuenta que recibe el dinero.
     * @param origen cuenta que transfiere el dinero.
     */
    public void transferencia(Conta destino, Conta origen) {
        double importe = Double.parseDouble(JOptionPane.showInputDialog("Cantidad a transferir:"));
        if (importe <= 0){
            JOptionPane.showMessageDialog(null, "Error, no se puede hacer la transferencia.");
        } else if (importe > origen.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Error, no se puede hacer la transferencia.");
        } else {
        origen.retirarSaldo(importe);
        destino.ingresarSaldo(importe);
        }
    }

}
