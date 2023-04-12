package entidades;

public class Mensagem {
    private String name;
    private String message;
    // O contato se precisasse verificar se fosse um email ou um telefone,
    // seria melhor criar uma classe de contato, e fazer as verificações
    // em uma classe separada, porém como não precisa, ser apeans uma string aqui
    // é mais pratico.
    private String contact;
    private int reason;

    public Mensagem(String name, String message, String contact, int reason) {
        this.name = name;
        this.message = message;
        this.contact = contact;
        this.reason = reason;

        System.out.println("Nova mensagem foi criada.");
    }

    public String getName() {
        return name;
    }
    public String getMessage() {
        return message;
    }
    public String getContact() {
        return contact;
    }
    public int getReason() {
        return reason;
    }

    @Override
    public String toString() {
        String aba = "";

        if (this.reason == 1) {
            aba = "Reclamacao";
        }
        if (this.reason == 2) {
            aba = "Sugestao";
        }

        if (this.name == "") {
        return "O contato " + this.contact
                + " na aba de " + aba + " digitou a mensagem:\n" + this.message;
        }

        return this.name + " com o contato " + this.contact
                + " na aba de " + aba + " digitou a mensagem:\n" + this.message;
    }
}