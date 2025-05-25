public enum TipoObraOpcao {
    LIVRO(1),
    REVISTA(2);

    private final int valor;

    TipoObraOpcao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
