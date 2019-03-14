package JoKenPo;

import java.util.Scanner;

public class JoKenPo {

    public static void main(String[] args) {
        // lócica do jogador
        int jogador;
        Scanner mao = new Scanner(System.in);
        System.out.println("-----------JKENPo----------");
        System.out.println("---------------------");
        System.out.println("1. Pedra");
        System.out.println("2. Papel");
        System.out.println("3. Tesoura");
        System.out.println("Digite a opção desejada: ");
        jogador = mao.nextInt();
        switch(jogador){
            case 1:
                System.out.println("Jogador escolheu Pedra ");
                break;
            case 2:
                 System.out.println("Jogador escolheu Papel");
             break;
            case 3:
                 System.out.println("Jogador escolheu Tesoura ");
          break;
            default:
                 System.out.println("Opção inválida ");
        }
        // lógica do computador
        int computador = (int)(Math.random()*3+1);
        switch(computador){
            case 1:
                System.out.println("Computador escolheu Pedra ");
                break;
            case 2:
                 System.out.println("Computdor escolheu Papel");
             break;
            case 3:
                 System.out.println("Computador escolheu Tesoura ");
          break;
        }
      //  lógica para determinar o vencedor
        if (jogador != computador) {
            if ((jogador == 1 && computador == 3)|| (jogador==2 && computador==1)
                    ||(jogador==3 && computador ==2))  {
                System.out.println("Jogador venceu");   
            } else {
                System.out.println("Computador venceu");
            }
   
            
        } else {
            System.out.println("EMPATE");
        }
 
    }
}
