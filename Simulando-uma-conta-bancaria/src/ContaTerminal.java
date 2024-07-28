import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args) {

        int numero;
        String agencia, nomeCliente;
        double saldo;

        Scanner scan = new Scanner(System.in);

        System.out.println("Olá, qual o seu nome? ");
        nomeCliente = scan.nextLine();

        System.out.println("Qual o número da sua conta? ");
        numero = scan.nextInt();
        scan.nextLine();

        System.out.println("Qual o número da sua agência? ");
        agencia = scan.nextLine();

        System.out.println("Quanto deseja depositar na sua conta? ");
        saldo = scan.nextDouble();
        scan.nextLine();

        Conta conta = new Conta(numero,agencia,nomeCliente,saldo);

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo R$%.2f já está disponível para saque",
                conta.getNomeCliente(),conta.getAgencia(),conta.getNumero(),conta.getSaldo());
    }
}
