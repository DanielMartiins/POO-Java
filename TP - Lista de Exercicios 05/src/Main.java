//9. Uma Biblioteca possui em seu acervo Revistas (título e número) e Livros (título e
//nome do autor). Na Biblioteca crie métodos para:
//a) Adicionar e remover Livros e Revistas do acervo;
//b) Emprestar e devolver Revistas e Livros;
//c) Listar as Revistas e Livros existentes na biblioteca com seu status (emprestado ou disponível).

import java.util.Scanner;
import java.util.ArrayList;

public class Main {



    final static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        ArrayList<Obra> acervo = new ArrayList<>();
        acervo.add(new Livro("Teste", "Daniel"));
        acervo.add(new Revista("Teste1", "123"));
        acervo.add(new Revista("Chad", "Manoel Gomes"));
        acervo.add(new Revista("Teste3", "12345"));
        acervo.add(new Livro("Teste22", "Daniel"));
        Biblioteca biblioteca = new Biblioteca(acervo);

        int op;
        while(true) {
            mostrarMenu();
            executarOpcaoMenu(biblioteca, scanner.nextInt());
        }
    }



    private static void mostrarMenu(){
            System.out.println("""
                    === Menu da Biblioteca ===:
                    0. Sair
                    1. Listar acervo
                    2. Adicionar/Remover obra
                    3. Emprestar/Devolver obra
                    """);
    }

    private static void executarOpcaoMenu(Biblioteca biblioteca, int op){
        if (op == MenuOpcao.SAIR.getValor()) {
            scanner.close();
            System.exit(0);
        } else {
            if (op == MenuOpcao.LISTAR_ACERVO.getValor()) {
                biblioteca.listarAcervoPorIndice();
                System.out.println("Pressione qualquer tecla para continuar...\n");
                scanner.nextLine();
                scanner.nextLine();
            }
            else if (op == MenuOpcao.ADICIONAR_OU_REMOVER_OBRA.getValor()) {
                eventoAdicionarOuRemoverObra(biblioteca);
            }
            else if (op == MenuOpcao.EMPRESTIMO_OBRA.getValor()) {
                eventoEmprestimoObra(biblioteca);
            }
            else
                System.err.println("ERRO: Opção inválida!");
        }
    }

    private static void eventoAdicionarOuRemoverObra(Biblioteca biblioteca){
        int op;
        Obra obra;

        while(true) {
            System.out.printf("Adicionar(%d) ou Remover (%d)?\n ",
                    AcaoOpcao.ADICIONAR_OBRA.getValor(), AcaoOpcao.REMOVER_OBRA.getValor());
            op = scanner.nextInt();

            if (op == AcaoOpcao.ADICIONAR_OBRA.getValor()) {
                biblioteca.getAcervo().add(solicitarObraParaAdicionar());
                break;
            }
            if (op == AcaoOpcao.REMOVER_OBRA.getValor()) {
                biblioteca.getAcervo().remove(biblioteca.getAcervo().get(solicitarObraPorIndice(biblioteca)));
                break;
            }
        }

    }

    private static void eventoEmprestimoObra(Biblioteca biblioteca) {
        int op;

        while (true) {
            System.out.printf("Emprestar(%d) ou devolver(%d)?\n",
                    AcaoOpcao.EMPRESTAR_OBRA.getValor(), AcaoOpcao.DEVOLVER_OBRA.getValor());
            op = scanner.nextInt();
            scanner.nextLine();
            if (op != AcaoOpcao.EMPRESTAR_OBRA.getValor() && op != AcaoOpcao.DEVOLVER_OBRA.getValor()) {
                System.err.println("ERRO: Opção inválida!");
                continue;
            } else
                break;
        }

        if (op == AcaoOpcao.EMPRESTAR_OBRA.getValor())
            biblioteca.emprestarObra(biblioteca.getAcervo().get(solicitarObraPorIndice(biblioteca)));
        if (op == AcaoOpcao.DEVOLVER_OBRA.getValor())
            biblioteca.devolverObra(biblioteca.getAcervo().get(solicitarObraPorIndice(biblioteca)));

    }

    private static int solicitarObraPorIndice(Biblioteca biblioteca){

        int indexObra;

        while(true) {
            biblioteca.listarAcervoPorIndice();
            System.out.println("Insira o índice da obra: ");
            indexObra = scanner.nextInt();
            if (0 <= (indexObra - 1) && (indexObra - 1) < biblioteca.getAcervo().size()){
                return indexObra - 1;
            }
        }
    }

    private static Obra solicitarObraParaAdicionar(){
        int tipoObra;
        String tituloObra;
        String autorLivro;
        String numeroRevista;

        while(true) {
            System.out.printf("Livro(%d) ou revista(%d)?\n", TipoObraOpcao.LIVRO.getValor(), TipoObraOpcao.REVISTA.getValor());
            tipoObra = scanner.nextInt();
            scanner.nextLine();
            if (tipoObra != TipoObraOpcao.LIVRO.getValor() && tipoObra != TipoObraOpcao.REVISTA.getValor()) {
                System.err.println("Tipo inválido. Insira 1 ou 2");
                continue;
            }
            else {
                break;
            }
        }

        do {
            System.out.println("Insira o titulo: ");
            tituloObra = scanner.nextLine();
        } while(tituloObra.isEmpty());
        if (tipoObra == TipoObraOpcao.LIVRO.getValor()){
            do {
                System.out.println("Insira o autor do livro: ");
                autorLivro = scanner.nextLine();
            } while(autorLivro.isEmpty());
            return new Livro(tituloObra, autorLivro);
        } else {
            do {
                System.out.println("Insira o numero da revista: ");
                numeroRevista = scanner.nextLine();
            } while(numeroRevista.isEmpty());
            return new Revista(tituloObra, numeroRevista);
        }
    }
}