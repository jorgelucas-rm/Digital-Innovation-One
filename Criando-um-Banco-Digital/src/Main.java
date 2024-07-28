public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Lucas", "123.456.789.00", "21/07/1999");

        Conta cc = new ContaCorrente(cliente, Agencia.A2107);
        Conta cp = new ContaPoupanca(cliente, Agencia.A1606);

        cc.depositar(100);
        cc.sacar(10);
        cc.transferir(20, cp);
        cc.sacar(100);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }

}