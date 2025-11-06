import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        
        System.out.print("digite seu nome: ");
        String nome = scanner.next();

        System.out.print("boa noite " + nome + " !");
    }
}