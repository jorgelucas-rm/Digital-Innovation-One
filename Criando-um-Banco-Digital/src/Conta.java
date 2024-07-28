public abstract class Conta {

    private static int SEQUENCIAL = 1;

    protected Agencia agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, Agencia agencia) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.conta = SEQUENCIAL++;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
        System.out.println("Deposito realizado");
        System.out.println("Saldo atual:" + this.saldo);

    }
    public void sacar(double valor){
        if(valor <= this.saldo){
            this.saldo -= valor;
            System.out.println("Saque realizado no valor de: " + valor);
            System.out.println("Saldo atual:" + this.saldo);

        }else {
            System.out.println("Saque não autorizado");
            System.out.println("Saldo atual:" + this.saldo);
        }
    }
    public void transferir(double valor, Conta conta){
        if(valor <= this.saldo){
            this.saldo -= valor;
            conta.depositar(valor);
            System.out.println("Transferencia realizada com sucesso!");
            System.out.println("Saldo atual:" + this.saldo);
        }else {
            System.out.println("Transferencia não autorizada");
            System.out.println("Saldo atual:" + this.saldo);
        }
    }

    protected void imprimirExtrato() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.conta);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }
}