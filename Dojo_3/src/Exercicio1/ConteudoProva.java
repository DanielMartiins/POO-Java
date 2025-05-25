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

public class ConteudoProva {

    private String texto;

    public ConteudoProva(String texto) {
        this.texto = texto;
    }
}
