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


public class Aluno {

    private final float MEDIA_PARA_PASSAR = 7;

    private final String matricula;
    private final String nome;
    private int idade;
    private Prova[] provas;
    private float media;
    private boolean provaFinal;

    public Aluno(String matricula, String nome, int idade, Prova[] prova){
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.provas = prova;
        this.media = media();
        this.provaFinal = provaFinal();
    }

    private float media(){
        float somaNotas = 0;
        float media = 0;
        int qtdProvas = provas.length - 1;

        if (this.provaFinal){
            for (Prova prova : this.provas){
                if (prova.getTipo() == TipoProva.PROVA_FINAL)
                    media = prova.getNota();
            }
        } else {
            for (Prova prova : this.provas) {
                somaNotas += prova.getNota();
                media = somaNotas / qtdProvas;
            }
        }

        return media;
    }

    private boolean provaFinal(){
        if (this.media >= MEDIA_PARA_PASSAR)
            return false;
        else
            return true;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean getProvaFinal(){
        return this.provaFinal;
    }

    public Prova[] getProvas() {
        return provas;
    }

    public float getMedia() {
        return media;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
}
