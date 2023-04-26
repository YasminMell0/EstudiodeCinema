package EstudioCinema.model.bean;

public class DiretorFilme {
    private int id;
    private int idD;
    private int idF;
    private String cinematografia;
    private Diretor d;
    private Filme f;

    
    public DiretorFilme(String cinematografia){
        this.cinematografia = cinematografia;
    }

    public DiretorFilme(int idD, int idF, String cinematografia) {
        this.idD = idD;
        this.idF = idF;
        this.cinematografia = cinematografia;
    }

    public DiretorFilme(int id, int idD, int idF, String cinematografia) {
        this.id = id;
        this.idD = idD;
        this.idF = idF;
        this.cinematografia = cinematografia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdD() {
        return idD;
    }

    public void setIdD(int idD) {
        this.idD = idD;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public Diretor getD() {
        return d;
    }

    public void setD(Diretor d) {
        this.d = d;
    }

    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    public String getCinematografia() {
        return cinematografia;
    }

    public void setCinematografia(String cinematografia) {
        this.cinematografia = cinematografia;
    }

    @Override
    public String toString() {
        return "DiretorFilme{" + "id=" + id + ", idD=" + idD + ", idF=" + idF + ", cinematografia=" + cinematografia + '}';
    }
    
}
