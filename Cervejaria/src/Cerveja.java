public class Cerveja {

    private int id;
    private String nome;
    private String estilo;
    private double teorAlcoolico;
    private int ibu;
    private String pais;
    private String fabricante;
    private java.sql.Date dataDegustacao;
    private String localDegustacao;
    private int nota;
    private String comentarios;
    private String sugestao;
    private byte[] foto; 
    private int usuarioId;

    public Cerveja() {
    }

    public Cerveja(int id, String nome, String estilo, double teorAlcoolico, int ibu, String pais, String fabricante,
                   java.sql.Date dataDegustacao, String localDegustacao, int nota, String comentarios,
                   String sugestao, byte[] foto, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.teorAlcoolico = teorAlcoolico;
        this.ibu = ibu;
        this.pais = pais;
        this.fabricante = fabricante;
        this.dataDegustacao = dataDegustacao;
        this.localDegustacao = localDegustacao;
        this.nota = nota;
        this.comentarios = comentarios;
        this.sugestao = sugestao;
        this.foto = foto;
        this.usuarioId = usuarioId;
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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public java.sql.Date getDataDegustacao() {
        return dataDegustacao;
    }

    public void setDataDegustacao(java.sql.Date dataDegustacao) {
        this.dataDegustacao = dataDegustacao;
    }

    public String getLocalDegustacao() {
        return localDegustacao;
    }

    public void setLocalDegustacao(String localDegustacao) {
        this.localDegustacao = localDegustacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
