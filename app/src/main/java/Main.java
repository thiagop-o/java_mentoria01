import calculadoras.CalculadoraArea;
import calculadoras.CalculadoraIMC;
import calculadoras.CalculadoraPadrao;

import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);



    public static void main(String[] args) {
        boolean continuar;

        String opcaoMenu;
        int validacao = 0;
        System.out.println("************************************************************");
        System.out.println("***************** BEM VINDO AO PROGRAMA 01 *****************");
        System.out.println("************************************************************");
        do {
            System.out.println();
            System.out.println("****  SELECIONE UM DAS CALCULADORAS QUE DESEJA UTILIZAR ****");
            System.out.println("**********        1 - CALCULADORA PADRÃO          **********");
            System.out.println("**********        2 - CALCULADORA DE IMC          **********");
            System.out.println("**********        3 - CALCULADORA DE ÁREA         **********");
            System.out.println("************************************************************\n");
            System.out.print("Digite a Opção: ");
            opcaoMenu = entrada.nextLine();

            do{
                try{
                    validacao = Integer.parseInt(opcaoMenu);
                    if (validacao <= 0 || validacao >= 4)
                        opcaoMenu = digitarOpcaoValida();

                }catch (Exception e){
                    validacao = 0;
                    System.out.printf("Você Digitou %s é não é um valor numerico e/ou inteiro!!%n",opcaoMenu);
                    opcaoMenu = digitarOpcaoValida();
                }
            }while(validacao <= 0 || validacao >= 4);

            switch (validacao){
                case 1:
                    CalculadoraPadrao.execute();
                    break;
                case 2:
                    CalculadoraIMC.execute();
                    break;
                case 3:
                    CalculadoraArea.execute();
                    break;
            }

            System.out.print("\nDeseja utilizar o programa novamente???? " +
                    "\n( S | N ): ");
            opcaoMenu = entrada.nextLine().toLowerCase();
            continuar = opcaoMenu.equals("s");
        }while (continuar);

    }

    private static String digitarOpcaoValida(){
        System.out.print("Por favor, digitar uma opção válida: ");
        return entrada.nextLine();
    }
}
