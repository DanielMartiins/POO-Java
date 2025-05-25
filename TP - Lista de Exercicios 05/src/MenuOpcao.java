public enum MenuOpcao {
    SAIR(0),
    LISTAR_ACERVO(1),
    ADICIONAR_OU_REMOVER_OBRA(2),
    EMPRESTIMO_OBRA(3);

    private final int valor;

    MenuOpcao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
