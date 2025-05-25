public enum AcaoOpcao {
    VOLTAR(0),
    ADICIONAR_OBRA(1),
    REMOVER_OBRA(2),
    EMPRESTAR_OBRA(1),
    DEVOLVER_OBRA(2);

    private final int valor;

    AcaoOpcao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
