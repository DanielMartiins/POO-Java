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

package Exercicio1;

public enum OpcaoMenu {

    CRIAR_ALUNO(1),
    LISTAR_ALUNOS(2),
    EXIBIR_ATRIBUTOS_ALUNO(3),
    DELETAR_ALUNO(4),
    ALTERAR_IDADE_ALUNO(5),
    NOTAS_ALUNOS(6),
    SITUACAO_PF_ALUNO(7),
    SAIR(0);

    private final int valor;

    OpcaoMenu(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
