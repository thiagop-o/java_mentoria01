package calculadoras;

import calculos.CalculoImpl;

import java.util.Scanner;

public class CalculadoraIMC {

    public static void execute(){
        Scanner entrada = new Scanner(System.in);
        CalculoImpl calc = new CalculoImpl();
        boolean continuar;
        String opcaoMenu;
        int validacao = 0;
        double[] numero = new double[2];
        System.out.println("\n***  CALCULADORA DE INDICE DE MASSA CORPORAL  ***");
        do {
            System.out.print("Digite seu peso em quilos: ");
            numero[0] = entrada.nextDouble();
            System.out.print("Digite sua altura em metros: ");
            numero[1] = entrada.nextDouble();
            calc.deveCalcular("imc",numero[0],numero[1]);

            System.out.print("\nDeseja realizar o calculo do IMC novamente???? " +
                    "\n( S | N ): ");
            opcaoMenu = entrada.next().toLowerCase();
            continuar = opcaoMenu.equals("s");
        }while (continuar);
    }
}
