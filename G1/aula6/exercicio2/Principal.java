public class Principal {
    public static void main(String[] args) {
        CalculadoraCientifica SomaString = new CalculadoraCientifica();
        CalculadoraCientifica SomaInt = new CalculadoraCientifica();
        CalculadoraCientifica SomaDouble = new CalculadoraCientifica();
        System.out.println(SomaDouble.somar(5.9d, 2.9d));
        System.out.println(SomaString.somar("o", "lá"));
        System.out.println(SomaInt.somar(5, 9));
    }
}