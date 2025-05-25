public class Obra {

    final private String titulo;
    private boolean disponibilidade;

    public Obra(String titulo){
        this.titulo = titulo;
        this.disponibilidade = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
}
