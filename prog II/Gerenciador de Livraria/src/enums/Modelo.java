package enums;

public enum Modelo {
    A4("A4"), A5("A5"), A1("A1");

    private Modelo(String descricao){
        this.descricao = descricao;
    }

    String descricao;

    public String getDescricao() {
        return descricao;
    }
}
