public interface ReprodutorMusical {

    public default void selecionarMusica(String musica){
        System.out.println("Selecionando a música: " + musica);
    }
    public default void tocar(){
        System.out.println("Tocando a música");

    }
    public default void pausar(){
        System.out.println("Pausando a música");
    }
}
