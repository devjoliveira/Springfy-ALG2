import java.util.Scanner;

public class Main extends Metodos {
    public static void main(String[] args) {

        Musica ms1 = new Musica("Duckworth", "Kendrick Lamar", 240, 4);
        Musica ms2 = new Musica("Até o Sol quis ver", "Exaltasamba", 240, 4);
        Musica ms3 = new Musica("Ela partiu", "Tim Maia", 260,3.20);
        Musica[] array = {ms1, ms2, ms3};

        String menu = """
                Springfy
                
                1 - Encontrar música
                2 - Deletar música
                3 - Imprimir lista de musicas
                4 - Encerrar programa
                
                Escolha uma opção:""";

        String menuSearch = """
                1 - Buscar pelo nome da musica
                2 - Buscar pelo artista
                3 - Cancelar
                
                Escolha uma opção:""";


        byte escolha;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println(menu);
            escolha = input.nextByte();
            switch (escolha) {
                case 1:
                    byte mnuSearch;
                    do {
                        System.out.println(menuSearch);
                        mnuSearch = input.nextByte();
                        switch (mnuSearch) {
                            case 1:
                                System.out.println("----- ENCONTRAR MUSICA POR NOME -----");
                                System.out.print("Digite o nome da música: ");
                                String nomeMusica = input.next();
                                int posicao1 = pesquisarNomeMusica(nomeMusica, array);
                                System.out.println("A música foi encontrada na posição "+ (posicao1+1) +" da lista.");
                                break;
                            case 2:
                                System.out.println("----- ENCONTRAR MUSICA POR ARTISTA -----");
                                System.out.print("Digite o nome do artista: ");
                                String nomeArtista = input.next();
                                int posicao2 = pesquisarNomeArtista(nomeArtista, array);
                                System.out.println("A música foi encontrada na posição "+ (posicao2+1) +" da lista.");
                                break;
                            case 3:
                                break;
                        }
                    }while (mnuSearch > 3 || mnuSearch < 1);
                case 2:
                    System.out.println("----- APAGAR MUSICA -----");
                    System.out.print("Digite o nome da música: ");
                    String nomeMusica = input.next();
                    removerMusica(nomeMusica, array);
                    break;

                case 3:
                    ordenacaoBb(array);
                    imprimirMusicas(array);
                    break;

                case 4:
                    break;
            }
        }while (escolha != 4);
    }
}
