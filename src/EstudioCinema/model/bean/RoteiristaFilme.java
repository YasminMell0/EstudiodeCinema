package EstudioCinema.model.bean;

public class RoteiristaFilme {
    private int id;
    private int idR;
    private int idF;
    private String tituloRoteiro;
    private Roteirista r;
    private Filme f;

    public RoteiristaFilme(String tituloRoteiro) {
        this.tituloRoteiro = tituloRoteiro;
    }

    public RoteiristaFilme(int id) {
        this.id = id;
    }
    
    public RoteiristaFilme(int idR, int idF, String tituloRoteiro) {
        this.idR = idR;
        this.idF = idF;
        this.tituloRoteiro = tituloRoteiro;
    }

    public RoteiristaFilme(int id, int idR, int idF, String tituloRoteiro) {
        this.id = id;
        this.idR = idR;
        this.idF = idF;
        this.tituloRoteiro = tituloRoteiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public int getIdF() {
        return idF;
    }

    public void setIdF(int idF) {
        this.idF = idF;
    }

    public Roteirista getR() {
        return r;
    }

    public void setR(Roteirista r) {
        this.r = r;
    }

    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    public String getTituloRoteiro() {
        return tituloRoteiro;
    }

    public void setTituloRoteiro(String tituloRoteiro) {
        this.tituloRoteiro = tituloRoteiro;
    }

    @Override
    public String toString() {
        return "RoteiristaFilme{" + "id=" + id + ", idR=" + idR + ", idF=" + idF + ", tituloRoteiro=" + tituloRoteiro + '}';
    }
    
    

    

}
