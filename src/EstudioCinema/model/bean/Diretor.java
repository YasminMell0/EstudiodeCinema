package EstudioCinema.model.bean;

public class Diretor {
    private int id;
    private int idF;
    private String nome;
    private String formacao;
    private String qtdFilmes;
    private Filme f;

    public Diretor(int id) {
        this.id = id;
    }

    public Diretor(String nome) {
        this.nome = nome;
    }

    public Diretor(int idF, String nome, String formacao, String qtdFilmes) {
        this.idF = idF;
        this.nome = nome;
        this.formacao = formacao;
        this.qtdFilmes = qtdFilmes;
    }

    public Diretor(int id, int idF, String nome, String formacao, String qtdFilmes) {
        this.id = id;
        this.idF = idF;
        this.nome = nome;
        this.formacao = formacao;
        this.qtdFilmes = qtdFilmes;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getQtdFilmes() {
        return qtdFilmes;
    }

    public void setQtdFilmes(String qtdFilmes) {
        this.qtdFilmes = qtdFilmes;
    }

    @Override
    public String toString() {
        return "Diretor{" + "id=" + id + ", idF=" + idF + ", nome=" + nome + ", formacao=" + formacao + ", qtdFilmes=" + qtdFilmes + '}';
    }

}
