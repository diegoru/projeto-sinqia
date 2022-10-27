import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner entrada = new Scanner(System.in);

        int tamanho = getQuantidade(entrada);
        double[] numeros = new double[tamanho];
        boolean valido = false;
        String tipoMedia;


        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = getValores(entrada, i + 1);
        }

        entrada.nextLine();
        while(!valido){
            System.out.print("Digite a média desejada (ARITMETICA ou HARMONICA): ");
            tipoMedia = entrada.nextLine();

            if (tipoMedia.equalsIgnoreCase("ARITMETICA")){
                System.out.print("Os numeros digitados são: " );
                for (double num: numeros) {
                    System.out.print(num + ", ");
                }
                System.out.println();
                System.out.println(media(numeros));
                valido = true;

            } else if (tipoMedia.equalsIgnoreCase("HARMONICA")) {
                System.out.print("Os numeros digitados são: " );
                for (double num: numeros) {
                    System.out.print(num + ", ");
                }
                System.out.println();
                System.out.println(hamonica(numeros));
                valido = true;

            } else {
                System.out.println("Tipo de média inválida!\n");
            }
        }

        entrada.close();
    }

    static int getQuantidade(Scanner input) {
        try {
            System.out.print("Informe a quantidade de valores: ");
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Quantidade inválida\n");
            input.next();
            return getQuantidade(input);
        }
    }

    static double getValores(Scanner input, int count) {
        try {
            System.out.print("Digite o "+ count + "º numero: ");
            return input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Numero inválido\n");
            input.next();
            return getValores(input, count);
        }
    }

    static double media(double[] array){
        double soma = 0;
        for (double num: array) {
            soma+=num;
        }
        return soma / array.length;
    }

    static double hamonica(double[] array){
        double soma = 0;
        for (double num : array) {
            soma += 1 / num;
        }
        return array.length / soma;
    }


}