package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Metodos {

    public static int ponteiro = -1;
    public static Musica[] array = new Musica[100];

    public static void menu() throws IOException {
        int escolha;
        do {
            System.out.println("""
                ----------------------S-p-r-i-n-g-f-y--------------------------------
                                              \s
                1 - Adicionar música
                2 - Encontrar música
                3 - Imprimir lista de músicas \s
                4 - Deletar música
                5 - Encerrar
                                              \s
                Escolha uma opção""");
            Scanner entrada = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            escolha = entrada.nextInt();
            switch (escolha) {
                case 2:
                    if (ponteiro == -1) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("""
                        1 - Buscar pelo nome da música
                        2 - Buscar pelo artista
                        3 - Cancelar
                                                  \s
                        Escolha uma opção:""");
                    int escolha2 = entrada.nextInt();
                    switch (escolha2) {
                        case 1:
                            System.out.println("----- ENCONTRAR MÚSICA POR NOME -----");
                            System.out.print("Digite o nome da música: ");
                            String nomeMusica = reader.readLine();
                            int posicao1 = Metodos.pesquisarNomeMusica(nomeMusica);
                            if (posicao1 != -1) {
                                System.out.println("A música foi encontrada na posição " + (posicao1 + 1) + " da lista.");
                            } else {
                                System.out.println("Música não encontrada");
                            }
                            break;
                        case 2:
                            System.out.print("----- ENCONTRAR MÚSICA POR ARTISTA -----\n");
                            System.out.print("Digite o nome do artista: ");
                            String nomeArtista = reader.readLine();
                            int posicao2 = Metodos.pesquisarNomeArtista(nomeArtista);
                            if (posicao2 != -1) {
                                System.out.println("A música foi encontrada na posição " + (posicao2 + 1) + " da lista.");
                            } else {
                                System.out.println("Música não encontrada");
                            }
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    if (ponteiro == -1) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    System.out.println("----- APAGAR MÚSICA -----");
                    System.out.print("Digite o nome da música: ");
                    String nomeMusicaDelete = reader.readLine();
                    Metodos.removerMusica(nomeMusicaDelete);
                    break;

                case 3:
                    if (ponteiro == -1) {
                        System.out.println("Lista Vazia");
                        break;
                    }
                    Metodos.ordenacaoBb();
                    Metodos.imprimirMusicas();
                    break;

                case 5:
                    return;
                case 1:
                    add();
                    break;
                default:
                    System.out.println("Número Inválido");
                    break;
            }
        } while (escolha >= 1 && escolha <= 5);
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
