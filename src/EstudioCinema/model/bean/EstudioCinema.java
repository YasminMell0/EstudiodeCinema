package EstudioCinema.model.bean;

public class EstudioCinema {
    private int id;
    private int idF;
    private int idD;
    private int idR;
    private String nome;
    private String dataCriacao;
    private Filme f;
    private Diretor d;
    private Roteirista r;
    

    public EstudioCinema(int id) {
        this.id = id;
    }

    public EstudioCinema(String nome) {
        this.nome = nome;
    }

    public EstudioCinema(String nome, String dataCriacao) {
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public EstudioCinema(int idF, int idD, int idR, String nome, String dataCriacao) {
        this.idF = idF;
        this.idD = idD;
        this.idR = idR;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public EstudioCinema(int id, int idF, int idD, int idR, String nome, String dataCriacao) {
        this.id = id;
        this.idF = idF;
        this.idD = idD;
        this.idR = idR;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    public Diretor getD() {
        return d;
    }

    public void setD(Diretor d) {
        this.d = d;
    }

    public Roteirista getR() {
        return r;
    }

    public void setR(Roteirista r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "EstudioCinema{" + "id=" + id + ", idF=" + idF + ", idD=" + idD + ", idR=" + idR + ", nome=" + nome + ", dataCriacao=" + dataCriacao + '}';
    }

    

}
