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
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        Musica musica1 = new Musica("Paradise City", "Guns N' Roses", new Duracao(6, 43));
        Musica musica2 = new Musica("Welcome To The Jungle", "Guns N' Roses", new Duracao(4, 39));
        Musica musica3 = new Musica("Sweet Child O' Mine", "Guns N' Roses", new Duracao(5, 03));

        ArrayList<Musica> musicas = new ArrayList<>(Arrays.asList(musica1, musica2, musica3));
        Album album = new Album("Appetite for Destruction", "Guns N' Roses", 3, musicas);

        while(true){
            try {
                mostrarMenu();
                op = scanner.nextInt();
                scanner.nextLine();
                if (op == OpcaoMenu.SAIR.getValor())
                    break;
                else {
                    executarOpcao(album, op);
                    System.out.println("Insira qualquer tecla para continuar...");
                    scanner.nextLine();
                }
            } catch (Exception e){
                System.err.println("Algo deu errado. Tente novamente.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void mostrarMenu(){
        System.out.printf("""
                
                ==================================MENU===================================
                |(%d) Checar se uma música está no album                                |
                |(%d) Verificar o nome da n-ésima música do album                       |
                |(%d) Imprimir os dados do álbum (título, artista e lista de músicas)   |
                |(%d) Alterar a posição de uma música na lista                          |
                |(%d) Adicionar música no album                                         |
                |(%d) Remover música do album                                           |
                |(%d) Sair                                                              |
                =========================================================================
                """,
                OpcaoMenu.CHECAR_SE_ALBUM_CONTEM_MUSICA.getValor(),
                OpcaoMenu.VERIFICAR_NOME_MUSICA.getValor(),
                OpcaoMenu.IMPRIMIR_DADOS_ALBUM.getValor(),
                OpcaoMenu.ALTERAR_POSICAO_MUSICA.getValor(),
                OpcaoMenu.ADICIONAR_MUSICA.getValor(),
                OpcaoMenu.REMOVER_MUSICA.getValor(),
                OpcaoMenu.SAIR.getValor());
    }

    private static void executarOpcao(Album album, int op){
        if (op == OpcaoMenu.CHECAR_SE_ALBUM_CONTEM_MUSICA.getValor())
            checarSeAlbumContemMusica(album);
        else if (op == OpcaoMenu.VERIFICAR_NOME_MUSICA.getValor())
            verificarNomeDeUmaMusicaNoAlbum(album);
        else if (op == OpcaoMenu.IMPRIMIR_DADOS_ALBUM.getValor())
            imprimirDadosDoAlbum(album);
        else if (op == OpcaoMenu.ALTERAR_POSICAO_MUSICA.getValor())
            alterarPosicaoMusica(album);
        else if (op == OpcaoMenu.ADICIONAR_MUSICA.getValor())
            adicionarMusica(album);
        else if (op == OpcaoMenu.REMOVER_MUSICA.getValor())
            removerMusica(album);
    }

    private static void checarSeAlbumContemMusica(Album album) {

        String musicaParaBuscar;

        do {
            System.out.println("Qual música deseja procurar?");
            musicaParaBuscar = scanner.nextLine();
        } while(musicaParaBuscar.isEmpty());

       if (album.contemMusica(musicaParaBuscar))
           System.out.println("O album contém a música");
       else
           System.out.println("O album não contém a música.");
    }

    private static void verificarNomeDeUmaMusicaNoAlbum(Album album){
        int numeroMusica;

        numeroMusica = buscarMusicaPorNumero(album);

        System.out.println("O nome da musica de nº " + numeroMusica + " é: " + album.getMusicas().get(numeroMusica - 1).getNome());
    }

    private static int buscarMusicaPorNumero(Album album) {
        int numeroMusica;
        while(true) {
            System.out.println("Numero da música do album a ser buscado: ");
            numeroMusica = scanner.nextInt();
            scanner.nextLine();
            if (numeroMusica >= 1 && numeroMusica <= album.getQtdMusicas())
                break;
            else
                System.err.println("Numero inválido. Insira um numero entre 1 e " + album.getQtdMusicas());
        }
        return numeroMusica;
    }

    private static void imprimirDadosDoAlbum(Album album){
        album.imprimirDados();
    }
    
    private static void alterarPosicaoMusica(Album album){
        
        int musica1;
        int musica2;
        
        System.out.println("[MUSICA 1]");
        musica1 = buscarMusicaPorNumero(album) - 1;

        System.out.println("[MUSICA 2]");
        musica2 = buscarMusicaPorNumero(album) - 1;

        Collections.swap(album.getMusicas(), musica1, musica2);
        System.out.println("Musicas trocadas com sucesso!");
    }

    private static void adicionarMusica(Album album){
        String nome;
        String artista;
        Duracao duracao;
            int duracaoMinutos;
            int duracaoSegundos;

        do {
            System.out.println("Nome da música: ");
            nome = scanner.nextLine();
        } while(nome.isEmpty());

        do {
            System.out.println("Artista: ");
            artista = scanner.nextLine();
        } while(artista.isEmpty());

        do {
            System.out.println("Duracao(Minutos e segundos separados por espaço ou por linha): ");
            duracaoMinutos = scanner.nextInt();
            scanner.nextLine();
            duracaoSegundos = scanner.nextInt();
            scanner.nextLine();
        } while(duracaoMinutos < 0 || duracaoSegundos < 0);
        duracao = new Duracao(duracaoMinutos, duracaoSegundos);

        album.getMusicas().add(new Musica(nome, artista, duracao));
        System.out.println("Musica adicionada com sucesso!");
    }

    private static void removerMusica(Album album){

        int numeroMusica = buscarMusicaPorNumero(album);
        Musica musicaParaRemover = album.getMusicas().get(numeroMusica);

        if(album.removerMusica(musicaParaRemover))
            System.out.println("Musica removida com sucesso!");
        else
            System.err.println("Não foi possível remover a música.");
    }
}
