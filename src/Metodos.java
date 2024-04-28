package src;
//Algoritmo de ordenação -
//Pesquisa binária por nome de música, com a opção de pesquisa por nome de artista -

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Escrever um método para remover uma música.
public class Metodos {

    public static int ponteiro = -1;
    public static Musica[] array = new Musica[100];

    public static boolean menu() throws IOException {
//        Musica ms1 = new Musica("Duckworth", "Kendrick Lamar", 240, 4);
//        Musica ms2 = new Musica("Até o Sol quis ver", "Exaltasamba", 240, 4);
//        Musica ms3 = new Musica("Ela partiu", "Tim Maia", 260, 3.20);
//        array[0] = ms1;
//        array[1] = ms2;
//        array[2] = ms3;
        int escolha;
        do {
            System.out.println("""
                               
----------------------S-p-r-i-n-g-f-y--------------------------------
                                               
1 - Encontrar música
2 - Deletar música
3 - Imprimir lista de musicas
4 - Encerrar programa
5 - Add música
                                               
Escolha uma opção""");
            Scanner entrada = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                     if(ponteiro == -1){
                                System.out.println("Lista Vazia");
                                break;
                            }
                    System.out.println("""
1 - Buscar pelo nome da musica
2 - Buscar pelo artista
3 - Cancelar
                                                       
Escolha uma opção:""");
                    int escolha2 = entrada.nextInt();
                    
                    switch (escolha2) {
                        case 1:
                            if(ponteiro == -1){
                                System.out.println("Lista Vazia");
                                break;
                            }
                            System.out.println("----- ENCONTRAR MUSICA POR NOME -----");
                            System.out.print("Digite o nome da música: ");
                            String nomeMusica = reader.readLine();
//                            System.out.println(nomeMusica);
                            int posicao1 = Metodos.pesquisarNomeMusica(nomeMusica);
                            if (posicao1 != -1) {
                                System.out.println("A música foi encontrada na posição " + (posicao1 + 1) + " da lista.");
                            } else {
                                System.out.println("Musica não encontrada");
                            }
                            break;
                        case 2:
                            System.out.print("----- ENCONTRAR MUSICA POR ARTISTA -----\n");
                            System.out.print("Digite o nome do artista: ");

                            String nomeArtista = reader.readLine();
//                            System.out.println(nomeArtista);
                            int posicao2 = Metodos.pesquisarNomeArtista(nomeArtista);
                            if (posicao2 != -1) {
                                System.out.println("A música foi encontrada na posição " + (posicao2 + 1) + " da lista.");
                            } else {
                                System.out.println("Musica não encontrada");
                            }
                            break;
                    }
                    break;
                case 2:
                     if(ponteiro == -1){
                                System.out.println("Lista Vazia");
                                break;
                            }
                    System.out.println("----- APAGAR MUSICA -----");
                    System.out.print("Digite o nome da música: ");
                    String nomeMusica = reader.readLine();
                    Metodos.removerMusica(nomeMusica);
                    break;

                case 3:
                     if(ponteiro == -1){
                                System.out.println("Lista Vazia");
                                break;
                            }
                    Metodos.ordenacaoBb();
                    Metodos.imprimirMusicas();
                    break;

                case 4:
                     
                    return false;
                case 5: 
                     
                    add();
                    break;
                default:
                    System.out.println("Numero Invalido");
                    menu();
                    break;
            }
        } while (escolha >= 1 && escolha <= 5);
        return false;
    }

    public static void add() throws IOException {
        if (ponteiro != 99) {

            Musica a;
            System.out.println("Escreva o nome da Musica: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String nomeDaMusica = reader.readLine();
            System.out.println("Escreva o nome do Artista: ");
            String nomeDoArtista = reader.readLine();
            System.out.println("Escreva a duração em segundos da musica: ");
            Scanner entrada = new Scanner(System.in);
            int duracaoEmSegundos = entrada.nextInt();
            System.out.println("Escreva a duração em minutos da musica: ");
            double duracaoEmMinutos = entrada.nextDouble();

           
                a = new Musica(nomeDaMusica, nomeDoArtista, duracaoEmSegundos, duracaoEmMinutos);
                ponteiro++;
                array[ponteiro] = a;
          
        }
    }

    public static void ordenacaoBb() {
        int n = ponteiro;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (array[j].getNome().compareTo(array[j + 1].getNome()) > 0) {
                    Musica aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    public static int pesquisarNomeMusica(String nomedamusica) {
        int inicio = 0;
        int fim = ponteiro;
        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            if (array[meio].getNome().equalsIgnoreCase(nomedamusica)) {
                return meio;
            }
            if (array[meio].getNome().compareToIgnoreCase(nomedamusica) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static int pesquisarNomeArtista(String nomedoartista) {
        int inicio = 0;
        int fim = ponteiro;
        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            if (array[meio].getArtista().equalsIgnoreCase(nomedoartista)) {
                return meio;
            }
            if (array[meio].getArtista().compareToIgnoreCase(nomedoartista) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void removerMusica(String nomedamusica) {
        if (ponteiro != -1) {

            int index = pesquisarNomeMusica(nomedamusica);
            if (index != -1) {
                System.out.println(array[index]);
                for (int i = index; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = null;
                System.out.println("Musica apagada!");
                ponteiro--;
            } else {
                System.out.println("Musica não encontrada.");
            }
            
        }
    }

    public static void imprimirMusicas() {
        ordenacaoBb();
        for (int i = 0; i <= ponteiro; i++) {
            if(array != null){
                System.out.println(array[i]);
            }
        }
    }

}
