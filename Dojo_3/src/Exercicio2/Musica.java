//Desafios adicionais:
//
//- Ao invés de uma música ser apenas uma string, transformá-la em uma outra
//classe, com características próprias (nome, artista, duração...);
//- Implementar métodos para adicionar e remover músicas ao Album.

package Exercicio2;

public class Musica {

    private String nome;
    private String artista;
    private int numeroNoAlbum;
    private Duracao duracao;

    public Musica(String nome, String artista, Duracao duracao) {
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public int getNumeroNoAlbum() {
        return numeroNoAlbum;
    }

    public Duracao getDuracao() {
        return duracao;
    }
}
