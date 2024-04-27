public class Musica {
    private String nome;
    private String artista;
    private int duracaoSegundos;
    private double duracaoMinutos;

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public double getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public double getDuracaoMinutos() {
        return duracaoMinutos;
    }

    @Override
    public String toString() {
        if (this.nome.isEmpty()) {
            return "sem música aqui";
        }
        return "\nMusica{" +
                "\nNome: "+this.nome+
                "\nArtista: "+this.artista+
                "\nDuração em segundos: "+this.duracaoSegundos+
                "\nDuração em minutos: "+this.duracaoMinutos+"\n}";

    }

    public Musica(String nome, String artista, int duracaoSegundos, double duracaoMinutos) {
        this.nome = nome;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.duracaoMinutos = duracaoMinutos;
    }
}
