//9. Uma Biblioteca possui em seu acervo Revistas (título e número) e Livros (título e
//nome do autor). Na Biblioteca crie métodos para:
//a) Adicionar e remover Livros e Revistas do acervo;
//b) Emprestar e devolver Revistas e Livros;
//c) Listar as Revistas e Livros existentes na biblioteca com seu status (emprestado ou disponível).

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Obra> acervo;

    public Biblioteca(ArrayList<Obra> acervo){
        this.acervo = acervo;
    }

    public void adicionarObra(Obra obra){
        this.acervo.add(obra);
    }

    public void removerObra(Obra obra){
        for (int i = 0; i < acervo.size(); i++){
            if (acervo.get(i).equals(obra))
                acervo.remove(i);
        }
    }

    public void emprestarObra(Obra obra){
        if (obraDisponivel(obra))
            obra.setDisponibilidade(false);
        else
            System.err.println("Esta obra já foi emprestada.");
    }

    public void devolverObra(Obra obra){
        if (!obraDisponivel(obra))
            obra.setDisponibilidade(true);
        else
            System.err.println("Esta obra já foi devolvida.");
    }
    public boolean obraDisponivel(Obra obra){
        for (int i = 0; i < acervo.size(); i++){
            if (acervo.get(i).equals(obra))
                return acervo.get(i).getDisponibilidade();
        }
        return false;
    }

    public void listarAcervoPorIndice(){
        int i = 1;
        for (Obra o : acervo){
            if (o instanceof Livro)
                System.out.printf("%d. [Livro] Título: \"%s\" | Autor: %s | Status: %s\n",
                        i++, ((Livro) o).getTitulo(), ((Livro) o).getAutor(), (obraDisponivel(o) ? "Disponível" : "Emprestado"));
            if (o instanceof Revista)
                System.out.printf("%d. [Revista] Título: \"%s | Numero: %s | Status: %s\n",
                        i++, ((Revista) o).getTitulo(), ((Revista) o).getNumero(), (obraDisponivel(o) ? "Disponivel" : "Emprestado"));
        }
    }

    public ArrayList<Obra> getAcervo(){
        return this.acervo;
    }
}
