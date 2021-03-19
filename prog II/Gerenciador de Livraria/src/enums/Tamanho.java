package enums;

public enum Tamanho {
    PEQUENO("Pequeno"),
    MEDIO("M�dio"),
    GRANDE("Grande");

    private Tamanho(String descricao){
        this.descricao = descricao;
    }

    private String descricao;

    public String getDescricao() {
        return descricao;
    }
}
