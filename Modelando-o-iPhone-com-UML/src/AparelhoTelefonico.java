public interface AparelhoTelefonico {

    public default void ligar(int numero){
        System.out.println("Ligando para: " + numero);
    }
    public default void atender(){
        System.out.println("Atendendo o celular");
    }
    public default void iniciarCorreioVoz(){
        System.out.println("Iniciando correio de voz");
    }
}
