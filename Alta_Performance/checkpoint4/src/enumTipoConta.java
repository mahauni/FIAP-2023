public enum enumTipoConta {
    CPF("CFP"),
    CNPJ("CNPJ");

    private final String tipoConta;

    enumTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}
