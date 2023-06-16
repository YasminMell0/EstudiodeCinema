package EstudioCinema.model.bean;

public class Filme {
    private int id;
    private String nome;
    private String genero;
    private String tramaPrincipal;
    private String anoLanc;
    private String desc;

    public Filme(int id) {
        this.id = id;
    }

    public Filme(String nome) {
        this.nome = nome;
    }

    public Filme(String nome, String genero, String tramaPrincipal, String anoLanc, String desc) {
        this.nome = nome;
        this.genero = genero;
        this.tramaPrincipal = tramaPrincipal;
        this.anoLanc = anoLanc;
        this.desc = desc;
    }

    public Filme(int id, String nome, String genero, String tramaPrincipal, String anoLanc, String desc) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.tramaPrincipal = tramaPrincipal;
        this.anoLanc = anoLanc;
        this.desc = desc;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTramaPrincipal() {
        return tramaPrincipal;
    }

    public void setTramaPrincipal(String tramaPrincipal) {
        this.tramaPrincipal = tramaPrincipal;
    }

    public String getAnoLanc() {
        return anoLanc;
    }

    public void setAnoLanc(String anoLanc) {
        this.anoLanc = anoLanc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", nome=" + nome + ", genero=" + genero + ", tramaPrincipal=" + tramaPrincipal + ", anoLanc=" + anoLanc + ", desc=" + desc + '}';
    }
}
