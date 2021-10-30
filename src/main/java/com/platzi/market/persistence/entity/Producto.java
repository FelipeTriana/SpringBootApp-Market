package com.platzi.market.persistence.entity;


import javax.persistence.*;
import java.util.List;

/*@Entity is the most important annotation, it means that the java class mapping a table of the database*/
@Entity
@Table(name = "productos") //So java understand that when we talk of the Producto class we want reference a productos table that exists in the database
public class Producto {

    @Id                                                        //Simple primary key of productos table
    @GeneratedValue( strategy = GenerationType.IDENTITY)       //Generates incremental values of identity as a primary key for a new products
    @Column(name = "id_producto")                              //Whenever a column is called different in the class attribute, we must include this notation
    private Integer idProducto;

    private String nombre;                                     //The name in the class is the same that in the database table

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /*
    * Important!!
    * insertable = false and updatable = false: It means that through this relation we will not insert, delete or update a new category, for do it we must do it directly since Categoria entity
    * */
    @ManyToOne                          //Relation in the database when one category can exist in many products
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)  //foraing key(primary key in categorias) in productos table
    private Categoria categoria;

    /* Esta relacion se puede especificar pero no es necesaria:
    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> comprasProductos;
     */

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
