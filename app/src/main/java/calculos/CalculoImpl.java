package calculos;

import java.util.Scanner;

public class CalculoImpl implements ICalculo{

    public void realizarCalculo(String operacao){
        Scanner scan = new Scanner(System.in);
        boolean continuar;
        String opcaoMenu;
        String pergunta1;
        double[] numero = new double[2];
        do {
            if(operacao.equals("quadrado")) pergunta1 = "Digite um numero para área do quadrado: ";
            else if (operacao.equals("circulo")) pergunta1 = "Digite o valor do raio: ";
            else pergunta1 = "Digite o valor do primeiro numero: ";
            System.out.print(pergunta1);
            numero[0] = scan.nextDouble();
            if(!operacao.equals("quadrado") && !operacao.equals("circulo")){
                System.out.print("Digite o valor do segundo numero: ");
                numero[1] = scan.nextDouble();
            }else{
                numero[1] = 1;
            }

            deveCalcular(operacao, numero[0], numero[1]);

            System.out.print("\nDeseja realizar esta operação novamente???? " +
                    "\n( S | N ): ");
            opcaoMenu = scan.next().toLowerCase();
            continuar = opcaoMenu.equals("s");
        }while (continuar);
        scan.close();
    }


    @Override
    public void deveCalcular(String opcao, double numero01, double numero02) {
        double result;
        switch (opcao){
            case "soma":
                result = numero01 + numero02;
                System.out.println("O Resultado da Soma é: " + result);
                break;
            case "subtração":
                result = numero01 - numero02;
                System.out.println("O Resultado da Subtração é: " + result);
                break;
            case "multiplicação":
                result = numero01 * numero02;
                System.out.println("O Resultado da Multiplicacão é: " + result);
                break;
            case "divisão":
                deveDividir(numero01,numero02);
                break;
            case "potenciação":
                result = Math.pow(numero01,numero02);
                System.out.println("O Resultado da Potenciação é: " + result);
                break;
            case "imc":
                deveCalcularImc(numero01,numero02);
                break;
            case "circulo":
                result = Math.PI*Math.pow(numero01,2);
                System.out.printf("A área do circulo é: %.2f cm²%n" , result);
                break;
            case "quadrado":
                result = Math.pow(numero01,2);
                System.out.printf("A área do quadrado é: %.2f cm²%n" , result);
                break;
            case "retangulo":
                result = numero01 * numero02;
                System.out.printf("A área do retangulo é: %.2f cm²%n" , result);
                break;
        }

    }

    private void deveCalcularImc(double numero1, double numero2){
        double result = numero1/Math.pow(numero2,2);

        System.out.printf("Seu IMC é: %.2f%n", result);
        if (result < 16) System.out.println("MAGREZA GRAU III");
        else if (result < 17) System.out.println("MAGREZA GRAU II");
        else if (result < 18.5) System.out.println("MAGREZA GRAU I");
        else if (result < 25) System.out.println("NORMAL");
        else if (result < 30) System.out.println("PRE-OBESO");
        else if (result < 35) System.out.println("OBESIDADE GRAU I");
        else if (result < 40) System.out.println("OBESIDADE GRAU II");
        else if (result >= 40) System.out.println("OBESIDADE GRAU III");
    }

    private void deveDividir(double numero1, double numero2){
        if (numero2 == 0) {
            System.out.println("Impossivel dividir por 0");
        }else{
            double result = numero1/numero2;
            System.out.println("O Resultado da Divisão é: " + result);
        }
    }
}
