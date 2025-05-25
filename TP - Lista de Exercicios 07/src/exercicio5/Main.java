/*
5. Crie uma classe Aluno com Nome, nota A1 e nota A2. Faça um programa para ler o nome, a nota
A1 e a nota A2 de uma lista de alunos, até que o usuário entre com um nome vazio. Ao final
imprima o nome do aluno, as notas A1 e A2 e a média. Caso a média seja maior que 6, imprima
APROVADO, senão imprima REPROVADO. Atente para o fato que nem todo aluno tem as
notas A1 e A2 (o aluno pode ter faltado à prova). Nesse caso, o programa deve imprimir
FALTOU na nota correspondente e REPROVADO.
 */

package exercicio5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    final static float FALTOU = -1;
    final static float MEDIA = 6;

    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<>();

        while(true) {
            Aluno aluno = solicitarETratarDadosDoAluno();
            if (aluno == null)
                break;
            else
                alunos.add(aluno);
        }

        for (Aluno aluno : alunos) {
            mostrarResultadoDoAluno(aluno);
        }
    }

    public static Aluno solicitarETratarDadosDoAluno(){
        String nome;
        float notaA1;
        float notaA2;

        System.out.println("Nome do aluno: ");
        if ((nome = scanner.nextLine()).isEmpty())
            return null;

        System.out.println("=== Nota A1 ===");
        notaA1 = solicitarNotaDoAluno();

        System.out.println("=== Nota A2 ===");
        notaA2 = solicitarNotaDoAluno();


        return new Aluno(nome, notaA1, notaA2);
    }

    public static float solicitarNotaDoAluno(){
        float nota;

        while(true){

            try {
                System.out.println("Nota do aluno de 0.0 a 10.0 (ou -1 se faltou): ");
                nota = scanner.nextFloat();
                if (!((nota >= 0.0 && nota <= 10.0) || nota == FALTOU))
                    System.out.println("Resposta invalida. Verifique sua entraad.");
                else
                    return nota;
            } catch (InputMismatchException erro) {
                System.err.println("ERRO: Verifique o formato da entrada");
            }

        }
    }

    public static void mostrarResultadoDoAluno(Aluno aluno){

        String nome = aluno.getNome();
        float notaA1 = aluno.getNotaA1();
        float notaA2 = aluno.getNotaA2();
        float mediaDoAluno = calcularMediaDoAluno(aluno);
        boolean alunoAprovado = (mediaDoAluno >= MEDIA && (!(notaA1 == FALTOU) || !(notaA2 == FALTOU)));

        System.out.println("Aluno: " + nome);
        System.out.println("Nota A1: " + (notaA1 == FALTOU ? "FALTOU" : notaA1));
        System.out.println("Nota A2: " + (notaA2 == FALTOU ? "FALTOU" : notaA2));
        System.out.println("Media: " + mediaDoAluno);
        System.out.println("Situação final: " + (alunoAprovado ? "APROVADO" : "REPROVADO"));
        if (notaA1 == FALTOU || notaA2 == FALTOU)
            System.out.println("Obs: Reprovado por falta em provas!");
    }

    public static float calcularMediaDoAluno(Aluno aluno){
        return ((aluno.getNotaA1() + aluno.getNotaA2())/2);
    }
}
