package poo;
import java.util.Random;
import java.util.Scanner;
 
public class PedraPapelTesoura {
    private Usuario usuario;
    private Computador computador;
    private int pontosusuario;
    private int pontoscomputador;
    private int numerosdejogos;
 
    private enum Escolher {
        PEDRA, PAPEL, TESOURA;
        public int compareEscolhas(Escolher outraescolha) {
            // Empate
            if (this == outraescolha)
                return 0;
 
            switch (this) {
            case PEDRA:
                return (outraescolha == TESOURA ? 1 : -1);
            case PAPEL:
                return (outraescolha == PEDRA ? 1 : -1);
            case TESOURA:
                return (outraescolha == PAPEL ? 1 : -1);
            }
 
            return 0;
        }
    }
 
    private class Usuario {
        private Scanner inputScanner;
 
        public Usuario() {
            inputScanner = new Scanner(System.in);
        }
 
        public Escolher getEscolher() {
            
            System.out.print("Pedra, papel ou tesoura? ");
            String entrada = inputScanner.nextLine();
            entrada = entrada.toUpperCase();
            char primeiraLetra = entrada.charAt(0);
            char segundaLetra = entrada.charAt(1);
            if (primeiraLetra == 'P' && (segundaLetra == 'E' || segundaLetra == 'A') || primeiraLetra == 'T') {
             // O usuário digitou uma entrada válida
              switch (primeiraLetra) {
                 case 'P':
                       if(segundaLetra == 'E') {return Escolher.PEDRA;} else {return Escolher.PAPEL;} 
                 case 'T':
               return Escolher.TESOURA;
        }
    }
            System.out.print("O usuário não digitou uma entrada válida, tente novamente");
            
            return getEscolher();
        }
 
        public boolean JogueNovamente() {
            System.out.print("Você deseja jogar novamente? ");
            String entrada = inputScanner.nextLine();
            entrada = entrada.toUpperCase();
            return entrada.charAt(0) == 'S';
        }
    }
 
    private class Computador {
        public Escolher getEscolher() {
            Escolher[] escolha = Escolher.values();
            Random random = new Random();
            int index = random.nextInt(escolha.length);
            return escolha[index];
        }
    }
 
    public PedraPapelTesoura() {
        usuario = new Usuario();
        computador = new Computador();
        pontosusuario = 0;
        pontoscomputador = 0;
        numerosdejogos = 0;
    }
 
    public void ComeçaJogo() {
        System.out.println("PEDRA, PAPEL, TESOURA!");
 
        // Obtém os movimentos
        Escolher usuarioEscolher = usuario.getEscolher();
        Escolher computadorEscolher = computador.getEscolher();
        System.out.println("\nVocê jogou " + usuarioEscolher + ".");
        System.out.println("Computador jogou " + computadorEscolher + ".\n");
 
        // Compara os movimentos e determina o vencedor
        int compareEscolhas = usuarioEscolher.compareEscolhas(computadorEscolher);
        switch (compareEscolhas) {
        case 0: // Empate
            System.out.println("Empate!");
            break;
        case 1: // Usuário ganhou
            System.out.println(usuarioEscolher + " ganha de " + computadorEscolher + ". Você venceu!");
            pontosusuario++;
            break;
        case -1: // Computador ganhou
            System.out.println(computadorEscolher + " ganha de " + usuarioEscolher + ". Você perdeu.");
            pontoscomputador++;
            break;
        }
        numerosdejogos++;
 
        if (usuario.JogueNovamente()) {
            System.out.println();
           ComeçaJogo();
        } else {
            ImprimirJogos();
        }
    }
    private void ImprimirJogos() {
        int ganhos = pontosusuario;
        int perdas = pontoscomputador;
        int empates = numerosdejogos - pontosusuario - pontoscomputador;
        double porcentagemGanhos = (ganhos + ((double) empates) / 2) / numerosdejogos;
 
        // Linha
        System.out.print("+");
        imprimeTraços(68);
        System.out.println("+");
 
        // Imprimir estatísticas
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "VITÓRIAS", "DERROTAS", "EMPATES", "JOGOS REALIZADOS", "PORCENTAGEM DE VITÓRIAS");
 
        // Linha
        System.out.print("|");
        imprimeTraços(10);
        System.out.print("+");
       imprimeTraços(10);
        System.out.print("+");
        imprimeTraços(10);
        System.out.print("+");
       imprimeTraços(16);
        System.out.print("+");
        imprimeTraços(18);
        System.out.println("|");
 
        // Imprimir valores
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                ganhos, perdas, empates, numerosdejogos, porcentagemGanhos * 100);
 
        // Linha
        System.out.print("+");
        imprimeTraços(68);
        System.out.println("+");
    }
 
    private void imprimeTraços(int numeroTraços) {
        for (int i = 0; i < numeroTraços; i++) {
            System.out.print("-");
        }
    }
 
    public static void main(String[] args) {
       PedraPapelTesoura game = new PedraPapelTesoura();
        game.ComeçaJogo();
    }
}
