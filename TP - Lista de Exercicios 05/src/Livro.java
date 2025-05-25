//9. Uma Biblioteca possui em seu acervo Revistas (título e número) e Livros (título e
//nome do autor). Na Biblioteca crie métodos para:
//a) Adicionar e remover Livros e Revistas do acervo;
//b) Emprestar e devolver Revistas e Livros;
//c) Listar as Revistas e Livros existentes na biblioteca com seu status (emprestado ou disponível).

import java.util.Objects;

public class Livro extends Obra{
    final private String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
    }


    public String getAutor() {
        return autor;
    }

    @Override
    public boolean equals(Object o) {
        Livro livro;

        if (o instanceof Livro)
            livro = (Livro) o;
        else return false;

        return (this.getTitulo().equalsIgnoreCase(livro.getTitulo())) && (this.getAutor().equalsIgnoreCase(livro.getAutor()));
    }
}
