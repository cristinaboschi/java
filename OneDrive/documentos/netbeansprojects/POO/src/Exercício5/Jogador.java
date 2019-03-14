package Exercício5;

import java.util.Scanner;

public class Jogador {

    public static void main(String[] args) {

        int escolha;

        Scanner entrada = new Scanner(System.in);

        do {

            System.out.println("------------Jogo PEDRA, PAPEL , TESOURA-----------------------");
            System.out.println("Coloque o número correspondente ao tipo de jogo que você deseja:");
            System.out.println("1 - computador x computador");
            System.out.println("2 - pessoa x computador");
            System.out.println("3 - Não jogar novamente");
            System.out.println("=>");

            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    Comp1XComp2();
                    break;
                case 2:
                    PessoaXComp();
                    break;
                default:
                    System.out.println("FIM");
                    break;
            }

        } while (escolha != 3);

    }

    public static void Comp1XComp2() {

        System.out.println("Você escolheu computador x computador");

        // lógica do computador1
        
        int computador1 = (int) (Math.random() * 3 + 1);

        switch (computador1) {
            case 1:
                System.out.println("Computador 1 escolheu Pedra ");
                break;
            case 2:
                System.out.println("Computador 1 escolheu Papel");
                break;
            case 3:
                System.out.println("Computador 1 escolheu Tesoura ");
                break;
        }

        // lógica do computador2
        
        int computador2 = (int) (Math.random() * 3 + 1);

        switch (computador2) {
            case 1:
                System.out.println("Computador 2 escolheu Pedra ");
                break;
            case 2:
                System.out.println("Computador 2 escolheu Papel");
                break;
            case 3:
                System.out.println("Computador 2 escolheu Tesoura ");
                break;
        }

        //  lógica para determinar o vencedor entre computador 1 e computador 2
        
        if (computador1 != computador2) {
            if ((computador1 == 1 && computador2 == 3) || (computador1 == 2 && computador2 == 1)
                    || (computador1 == 3 && computador2 == 2)) {

                System.out.println("Computador 1 venceu");

            } else {

                System.out.println("Computador 2 venceu");
            }

        } else {
            System.out.println("EMPATE");
        }
    }

    public static void PessoaXComp() {

        System.out.println("Você escolheu pessoa x computador");

        // lócica do jogador
        int jogador;

        Scanner mao = new Scanner(System.in);

        System.out.println("-----------JKENPo----------");
        System.out.println("1. Pedra");
        System.out.println("2. Papel");
        System.out.println("3. Tesoura");
        System.out.println("Digite o número correspondente da opção desejada: ");

        jogador = mao.nextInt();

        switch (jogador) {
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
        
        int computador = (int) (Math.random() * 3 + 1);

        switch (computador) {
            case 1:
                System.out.println("Computador escolheu Pedra ");
                break;
            case 2:
                System.out.println("Computador escolheu Papel");
                break;
            case 3:
                System.out.println("Computador escolheu Tesoura ");
                break;
            default:
                System.out.println("Opção inválida ");
        }

        //  lógica para determinar o vencedor
        
        if (jogador != computador) {
            if ((jogador == 1 && computador == 3) || (jogador == 2 && computador == 1)
                    || (jogador == 3 && computador == 2)) {

                System.out.println("Jogador venceu");

            } else {

                System.out.println("Computador venceu");

            }
        } else {

            System.out.println("EMPATE");

        }
    }
}
