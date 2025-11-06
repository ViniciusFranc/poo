public class Forma {

    String cor;

    public static void main(String[] args) {
        IAreaCalculavel circulo = new Circulo(3f,"vermelho");
        IAreaCalculavel retangulo = new Retangulo(5f,7f,"azul");

        retangulo.exibir();
        circulo.exibir();
    }
}