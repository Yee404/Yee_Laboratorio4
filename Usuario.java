public class Usuario {
    private String usuario;
    private String contrasenna;
    private String claseVuelo;
    private int codigo;

    // _Constructor____________________________
    public Usuario(String usuario, String contrasenna, int codigo, String claseVuelo) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
        this.codigo = codigo;
        this.claseVuelo = claseVuelo;

    }

    // _Getters________________________________
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    // _Setters________________________________
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

}
