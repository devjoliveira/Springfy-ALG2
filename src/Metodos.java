
//Algoritmo de ordenação -
//Pesquisa binária por nome de música, com a opção de pesquisa por nome de artista -
//Escrever um método para remover uma música.

import java.util.Scanner;

public class Metodos {

    public static void ordenacaoBb(Musica[] nomedoarray) {
        int n = nomedoarray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nomedoarray[j].getNome().compareTo(nomedoarray[j + 1].getNome()) > 0) {
                    Musica aux = nomedoarray[j];
                    nomedoarray[j] = nomedoarray[j + 1];
                    nomedoarray[j + 1] = aux;
                }
            }
        }
    }

    public static int pesquisarNomeMusica(String nomedamusica, Musica[] nomedoarray) {
        int inicio = 0;
        int fim = nomedoarray.length - 1;
        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            if (nomedoarray[meio].getNome().equals(nomedamusica)) {
                return meio;
            }
            if (nomedoarray[meio].getNome().compareTo(nomedamusica) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static int pesquisarNomeArtista(String nomedoartista, Musica[] nomedoarray) {
        int inicio = 0;
        int fim = nomedoarray.length - 1;
        while (inicio <= fim) {
            int meio = (fim + inicio) / 2;
            if (nomedoarray[meio].getArtista().equalsIgnoreCase(nomedoartista)) {
                return meio;
            }
            if (nomedoarray[meio].getArtista().compareToIgnoreCase(nomedoartista) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void removerMusica(String nomedamusica, Musica[]nomedoarray) {
        int index = pesquisarNomeMusica(nomedamusica, nomedoarray);
        if (index != -1) {
            for (int i = index; i < nomedoarray.length - 1; i++) {
                nomedoarray[i] = nomedoarray[i +1];
            }
            nomedoarray[nomedoarray.length - 1] = null;
            System.out.println("Musica apagada!");
        } else {
            System.out.println("Musica não encontrada.");
        }
    }

    public static void imprimirMusicas(Musica[]nomedoarray){
        for (int i = 0; i<nomedoarray.length; i++){
            if (nomedoarray[i] != null) {
                System.out.println(nomedoarray[i]);
            }
        }
    }



}
