//9. Uma Biblioteca possui em seu acervo Revistas (título e número) e Livros (título e
//nome do autor). Na Biblioteca crie métodos para:
//a) Adicionar e remover Livros e Revistas do acervo;
//b) Emprestar e devolver Revistas e Livros;
//c) Listar as Revistas e Livros existentes na biblioteca com seu status (emprestado ou disponível).

import java.util.Objects;

public class Revista extends Obra{

    final private String numero;

    public Revista (String titulo, String numero){
        super(titulo);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        Revista revista;

        if (o instanceof Revista)
            revista = (Revista) o;
        else return false;

        return (this.getTitulo().equalsIgnoreCase(revista.getTitulo())) && (this.numero.equalsIgnoreCase(revista.getNumero()));
    }
}
