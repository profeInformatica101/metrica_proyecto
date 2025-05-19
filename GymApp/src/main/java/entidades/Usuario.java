/*
 * Entidad Usuario
 */
package entidades;

/**
 *
 * @author SGame
 */
public class Usuario {
    private String id;
    private String nombre;
    private String password;
    private boolean esAdmin;
//    private List<Pedido> pedidos;

    //¿pq?
//    public Usuario(){
//        pedidos = new ArryaList<>();
//    }
    
    public Usuario(String id, String nombre, String password, boolean esAdmin) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.esAdmin = esAdmin;
//        this.pedidos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

//    public List<Pedido> getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(List<Pedido> pedidos) {
//        this.pedidos = pedidos;
//    }
//
//    public void agregarPedido(Pedido pedido){
//        this.pedidos.add(pedido);
//    }
    
    @Override
    public String toString(){
        return nombre;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 83 * hash + Objects.hashCode(this.id);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Usuario other = (Usuario) obj;
//        return Objects.equals(this.id, other.id);
//    }
}
