    import java.util.Scanner;

    public class exercicio3 {
        public static void main (String[] args) {

            Scanner scanner = new Scanner (System.in);

            System.out.print("digite um numero: ");
            int n1 = scanner.nextInt();

            System.out.print("digite outro numero: ");
            int n2 = scanner.nextInt();

            int resultSoma = n1+n2;
            int resultSub = n1-n2;  
            int resultDiv = n1/n2;
            int resultMult = n1*n2;

            System.out.println("A soma deu: " + resultSoma);
            System.out.println("A subtração deu: " + resultSub);
            System.out.println("A divisão deu: " + resultDiv);
            System.out.println("A multiplicação deu: " + resultMult);
        }
    }