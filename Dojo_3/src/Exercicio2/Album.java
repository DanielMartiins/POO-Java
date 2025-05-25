/*
================================================================================
Exercício 2

Implemente a classe “Album”, que representa um CD, possuindo um título, artista,
quantidade de músicas e lista de músicas*. Para que um novo álbum seja criado,
ele precisa receber todas essas informações necessárias. Além dessas
características, implemente também métodos para:

- Checar se uma música está no álbum;
- Verificar o nome da n-ésima música do álbum;
- Imprimir os dados do álbum (título, artista e lista de músicas);
- Alterar a posição de uma música na lista;
================================================================================
*/

package Exercicio2;

import java.util.ArrayList;

public class Album {

    private String titulo;
    private String artista;
    private int qtdMusicas;
    private ArrayList<Musica> musicas;

    public Album(String titulo, String artista, int qtdMusicas, ArrayList<Musica> musicas) {
        this.titulo = titulo;
        this.artista = artista;
        this.qtdMusicas = qtdMusicas;
        this.musicas = musicas;
    }

    public String nomeMusica(int numeroMusica){
        return this.musicas.get(numeroMusica).getNome();
    }

    public boolean contemMusica(String nomeDaMusica){
        for (Musica musica : this.musicas){
            if (musica.getNome().equalsIgnoreCase(nomeDaMusica))
                return true;
        }
        return false;
    }

    public void imprimirDados(){
        System.out.println("Título: " + this.titulo);
        System.out.println("Artista: " + this.titulo);
        System.out.println("Lista de Músicas: ");
        for (Musica musica : this.musicas){
            System.out.printf("\t%d. '%s' (%02d:%02d)\n",
                    this.musicas.indexOf(musica) + 1,
                    musica.getNome(),
                    musica.getDuracao().getMinutos(),
                    musica.getDuracao().getSegundos());
        }
    }

    public boolean removerMusica(Musica musica){
        return this.musicas.remove(musica);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getQtdMusicas() {
        return qtdMusicas;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

}
