package calculadoras;

import calculos.CalculoImpl;

import java.util.Scanner;

public class CalculadoraArea{
    static Scanner entrada = new Scanner(System.in);
    public static void execute(){
        CalculoImpl calc = new CalculoImpl();

        boolean continuar;

        String opcaoMenu;
        int validacao = 0;
        do{
            System.out.println("******  SELECIONE UMAS DAS OPÇÕES ABAIXO  ******");
            System.out.println("**********         1 - CIRCULO        **********");
            System.out.println("**********        2 - QUADRADO        **********");
            System.out.println("**********        3 - RETANGULO       **********");

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
            }while(validacao <= 0 || validacao >= 6);

            switch (validacao){
                case 1:
                    calc.realizarCalculo("circulo");
                    break;
                case 2:
                    calc.realizarCalculo("quadrado");
                    break;
                case 3:
                    calc.realizarCalculo("retangulo");
                    break;
            }


            System.out.print("\nDeseja realizar um novo calculo???? " +
                    "\n( S | N ): ");
            opcaoMenu = entrada.next().toLowerCase();
            continuar = opcaoMenu.equals("s");
        }while(continuar);
    }

    private static String digitarOpcaoValida(){
        System.out.print("Por favor, digitar uma opção válida: ");
        return entrada.nextLine();
    }
}
