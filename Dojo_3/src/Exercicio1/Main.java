/*
=============================================================================
Exercício 1

Implemente a classe Aluno, com os atributos “matricula”, “nome”, e “idade”.

Em seguida, escreva um programa que permita que:
- Um usuário crie novos Alunos;
- Liste todos os alunos existentes;
- Exiba todos os atributos de um aluno específico;
- Delete um aluno específico;
- Altere a idade de um aluno específico.

Implemente esse sistema através de um menu de opções numéricas, selecionadas
pelo input do usuário no teclado.
=============================================================================
*/

/*
================================================================================
Adicione uma classe Prova no exercício anterior. A Prova tem três atributos
chamados tipo (ex: “Avaliação 1”, “Avaliação 2” e “Prova Final) do tipo enum, nota
do tipo float e conteudoProva que deve ser do tipo ConteudoProva com um atributo
chamado texto do tipo String.

Um Aluno deve ter uma lista (vetor) de avaliações do tipo Prova. O Aluno deve ser
capaz de calcular a sua média e saber se está em prova final.

Seu programa deve interagir com o usuário para informar as notas de todos os
alunos cadastrados. Considerando quem ficou em prova final ou não.
================================================================================
*/

package Exercicio1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    final static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        Prova prova1 = new Prova(TipoProva.AVALIACAO_1, 7.4f, new ConteudoProva("aaaaa"));
        Prova prova2 = new Prova(TipoProva.AVALIACAO_2, 3.4f, new ConteudoProva("aaaddaa"));
        Prova provaFinal = new Prova(TipoProva.PROVA_FINAL, 9.4f, new ConteudoProva("aaaddddaa"));

        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("111111", "Daniel de Morais Martins", 19, new Prova[]{prova1, prova2}));
        alunos.add(new Aluno("222222", "Rafael Teixeira de Lima", 21, new Prova[]{prova1, prova2}));
        alunos.add(new Aluno("333333", "Jefferson Uébeti Simões ", 16, new Prova[]{prova1, prova2}));
        int op;


        while(true){
            try {
                mostrarMenu();
                op = Integer.parseInt(scanner.nextLine());
                if (op == OpcaoMenu.SAIR.getValor())
                    break;
                else {
                    executarOpcao(alunos, op);
                }
            } catch(Exception e){
                System.err.println("Algo deu errado. Erro:" + e);

            }
        }
        scanner.close();
    }



    private static void mostrarMenu(){
        System.out.printf("""
                ======================= Menu =======================
                Escolha uma opção inserindo seu número:
                    (%s) Criar novos Alunos
                    (%s) Listar todos os alunos existentes
                    (%s) Exibir todos os atributos de um aluno específico
                    (%s) Deletar um aluno específico
                    (%s) Alterar a idade de um aluno específico
                    (%s) Informar notas de todos os alunos
                    (%s) Saber se aluno específico está de prova final
                    (%s) Sair do sistema
                """,
                OpcaoMenu.CRIAR_ALUNO.getValor(),
                OpcaoMenu.LISTAR_ALUNOS.getValor(),
                OpcaoMenu.EXIBIR_ATRIBUTOS_ALUNO.getValor(),
                OpcaoMenu.DELETAR_ALUNO.getValor(),
                OpcaoMenu.ALTERAR_IDADE_ALUNO.getValor(),
                OpcaoMenu.NOTAS_ALUNOS.getValor(),
                OpcaoMenu.SITUACAO_PF_ALUNO.getValor(),
                OpcaoMenu.SAIR.getValor());
    }



    private static void executarOpcao(ArrayList<Aluno> alunos, int opcao){
        if (opcao == OpcaoMenu.CRIAR_ALUNO.getValor())
            adicionarAluno(alunos);
        else if (opcao == OpcaoMenu.LISTAR_ALUNOS.getValor())
            listarAlunos(alunos);
        else if (opcao == OpcaoMenu.EXIBIR_ATRIBUTOS_ALUNO.getValor())
            exibirAtributosAluno(alunos);
        else if (opcao == OpcaoMenu.DELETAR_ALUNO.getValor())
            removerAluno(alunos);
        else if (opcao == OpcaoMenu.ALTERAR_IDADE_ALUNO.getValor())
            alterarIdadeAluno(alunos);
        else if (opcao == OpcaoMenu.NOTAS_ALUNOS.getValor())
            exibirNotasAlunos(alunos);
        else if (opcao == OpcaoMenu.SITUACAO_PF_ALUNO.getValor())
            exibirSituacaoFinalAluno(buscarAluno(alunos));
        else
            System.err.println("Opção inválida!");
    }



    private static void adicionarAluno(ArrayList<Aluno> alunos){
        int idade;
        float nota;
        String nome;
        String matricula;
        Prova avaliacao1 = new Prova(TipoProva.AVALIACAO_1, 0, new ConteudoProva("Calcule 2+2"));
        Prova avaliacao2 = new Prova(TipoProva.AVALIACAO_1, 0, new ConteudoProva("Calcule 3+3"));
        Prova Pf;

        System.out.println("[Adição de aluno]");
        do {
            System.out.println("Nome do aluno: ");
            nome = scanner.nextLine();
        } while(nome.isEmpty());

        do {
            System.out.println("Matricula: ");
            matricula = scanner.nextLine();
        } while(matricula.isEmpty());

        do {
            System.out.println("Idade: ");
            idade = Integer.parseInt(scanner.nextLine());
            if (idade <= 0)
                System.err.println("ERRO: O aluno voltou pro tempo antes de ter nascido foi?");
        } while(idade <= 0);
        
        do{
            System.out.println("Nota da prova 1: ");
            nota = Float.parseFloat(scanner.nextLine());
        } while (nota < 0 || nota > 10);
        avaliacao1.setNota(nota);

        do{
            System.out.println("Nota da prova 2: ");
            nota = Float.parseFloat(scanner.nextLine());
        } while (nota < 0 || nota > 10);
        avaliacao2.setNota(nota);
        
        alunos.add(new Aluno(matricula, nome, idade, new Prova[]{avaliacao1, avaliacao2}));
    }



    private static void listarAlunos(ArrayList<Aluno> alunos){
        System.out.println("========= Alunos =========");
        for (int i = 0; i < alunos.size(); i++){
            System.out.println((i+1) + ". " + alunos.get(i).getNome());
        }
    }



    private static void exibirAtributosAluno(ArrayList<Aluno> alunos) {
        Aluno aluno;

        System.out.println("[Exibir atributos de um aluno]");
        aluno = buscarAluno(alunos);
        if (aluno == null)
            System.err.println("Não foi possível exibir os atributos do aluno.");
        else{
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Idade: " + aluno.getIdade());
        }
    }



    private static void exibirNotasAlunos(ArrayList<Aluno> alunos){
        for (Aluno aluno : alunos){
            exibirNotasAluno(aluno);
        }
    }



    private static void exibirNotasAluno(Aluno aluno) {
        float nota;
        TipoProva tipoProva;

        System.out.println("Notas do aluno " + aluno.getNome() + ": ");
        for (int i = 0; i < aluno.getProvas().length; i++){
            nota = aluno.getProvas()[i].getNota();
            tipoProva = aluno.getProvas()[i].getTipo();

            if (tipoProva == TipoProva.AVALIACAO_1)
                System.out.println("\tNota da avaliação 1: " + nota);
            else if (tipoProva == TipoProva.AVALIACAO_2)
                System.out.println("\tNota da avaliação 2: " + nota);
            else if (tipoProva == TipoProva.PROVA_FINAL)
                System.out.println("\tNota da prova final: " + nota);
        }
        System.out.println("\tMédia do aluno: " + aluno.getMedia());
    }



    private static void exibirSituacaoFinalAluno(Aluno aluno){

        if (aluno == null){
            System.out.println("Não foi possível exibir a situação final do aluno");
        } else {
            exibirNotasAluno(aluno);
            if (aluno.getProvaFinal())
                System.out.println("Aluno está de prova final");
            else {
                System.out.println("O aluno não está de prova final.");
            }
        }
    }



    private static void alterarIdadeAluno(ArrayList<Aluno> alunos){

        int idade;
        Aluno aluno;

        System.out.println("[Alterar idade de um aluno]");
        aluno = buscarAluno(alunos);

        if (aluno == null)
            System.err.println("Não foi possível alterar a idade do aluno.");
        else {
            System.out.println("Insira a idade do aluno: ");
            idade = Integer.parseInt(scanner.nextLine());
            aluno.setIdade(idade);
        }
    }



    private static void removerAluno(ArrayList<Aluno> alunos){

        System.out.println("[Remoção de aluno]");
        Aluno aluno = buscarAluno(alunos);
        if (alunos.remove(aluno))
            System.out.println("Aluno removido com sucesso");
        else
            System.err.println("Não foi possível remover o aluno.");

    }



    private static Aluno buscarAluno(ArrayList<Aluno> alunos){
        int opBusca;
        int opTentarNovamente;
        Aluno alunoEncontrado = null;

        while(true) {

            while (true) {
                try {
                    System.out.println("Deseja buscar o aluno por nome(1) ou por matrícula (2)?");
                    opBusca = Integer.parseInt(scanner.nextLine());
                    if (opBusca != 1 && opBusca != 2)
                        System.err.println("Opção Inválida!");
                    else
                        break;
                } catch (NumberFormatException ignored) {
                }
            }
            switch (opBusca) {
                case 1 -> alunoEncontrado = buscarAlunoPorNome(alunos);
                case 2 -> alunoEncontrado = buscarAlunoPorMatricula(alunos);
            }

            //Checar se o aluno foi encontrado (Se não for encontrado será null)
            if (alunoEncontrado != null)
                return alunoEncontrado;
            else{
                System.err.println("Aluno não encontrado.");
                while(true) {
                    try {
                        System.out.println("Tentar novamente? Sim(1), Nao(2)");
                        opTentarNovamente = Integer.parseInt(scanner.nextLine());
                        if (opTentarNovamente == 1)
                            break;
                        else if (opTentarNovamente == 2)
                            return alunoEncontrado;
                        else
                            System.err.println("Opção inválida.");
                    } catch(NumberFormatException ignored){}
                }
            }

        }
    }

    private static Aluno buscarAlunoPorNome(ArrayList<Aluno> alunos){
        String nomeAluno;

        do{
            System.out.println("Insira o nome completo do aluno: ");
            nomeAluno = scanner.nextLine();
        } while (nomeAluno.isEmpty());

        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nomeAluno))
                return aluno;
        }

        return null;
    }

    private static Aluno buscarAlunoPorMatricula(ArrayList<Aluno> alunos){
        String matriculaAluno;

        do{
            System.out.println("Insira a matrícula do aluno: ");
            matriculaAluno = scanner.nextLine();
        } while (matriculaAluno.isEmpty());

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matriculaAluno))
                return aluno;
        }

        return null;
    }
}