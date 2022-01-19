package calculadoras;

import calculos.CalculoImpl;

import java.util.Scanner;

public class CalculadoraPadrao {

    public static void execute(){
        CalculoImpl calc = new CalculoImpl();
        Scanner entrada = new Scanner(System.in);
        boolean continuar;
        String opcaoMenu;
        int validacao = 0;
        do{
            System.out.println("******  SELECIONE UMAS DAS OPÇÕES ABAIXO  ******");
            System.out.println("**********         1 - SOMA           **********");
            System.out.println("**********       2 - SUBTRAÇÃO        **********");
            System.out.println("**********      3 - MULTIPLICACÃO     **********");
            System.out.println("**********        4 - DIVISAO         **********");
            System.out.println("**********       5 - POTENCIAÇÃO      **********");
            System.out.print("Digite a Opção: ");
            opcaoMenu = entrada.nextLine();

            do{
                try{
                    validacao = Integer.parseInt(opcaoMenu);
                    if (validacao <= 0 || validacao >= 6)
                        opcaoMenu = digitarOpcaoValida();
                }catch (Exception e){
                    validacao = 0;
                    System.out.printf("Você Digitou %s é não é um valor numerico e/ou inteiro!!%n",opcaoMenu);
                    opcaoMenu = digitarOpcaoValida();
                }
            }while(validacao <= 0 || validacao >= 6);

            switch (validacao){
                case 1:
                    calc.realizarCalculo("soma");
                    break;
                case 2:
                    calc.realizarCalculo("subtração");
                    break;
                case 3:
                    calc.realizarCalculo("multiplicação");
                    break;
                case 4:
                    calc.realizarCalculo("divisão");
                    break;
                case 5:
                    calc.realizarCalculo("potenciação");
                    break;
            }
            System.out.print("\nDeseja realizar um novo calculo???? " +
                    "\n( S | N ): ");
            opcaoMenu = entrada.next().toLowerCase();
            continuar = opcaoMenu.equals("s");
        }while(continuar);
        entrada.close();
    }
    private static String digitarOpcaoValida(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Por favor, digitar uma opção válida: ");
        return entrada.nextLine();
    }
}
