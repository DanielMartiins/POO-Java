package exercicio5;

import java.util.Objects;

public class Aluno {
    String nome;

    private float notaA1, notaA2;

    public Aluno(String nome, float notaA1, float notaA2){
        this.nome = nome;
        this.notaA1 = notaA1;
        this.notaA2 = notaA2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Float.compare(aluno.notaA1, notaA1) == 0 && Float.compare(aluno.notaA2, notaA2) == 0 && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, notaA1, notaA2);
    }

    public String getNome(){
        return nome;
    }

    public float getNotaA1() {
        return notaA1;
    }

    public float getNotaA2(){
        return notaA2;
    }
}
