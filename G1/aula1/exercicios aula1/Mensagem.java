import java.util.Scanner;

public class Mensagem {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        String msg = scanner.nextLine();

        String MSG = lerNome(msg);

        System.out.print(MSG);
    }

    public static String lerNome(String msg1) {
        String resultado = msg1.toUpperCase();
        return resultado;   
    }
}