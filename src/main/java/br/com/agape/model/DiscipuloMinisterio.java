//package br.com.agape.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "tb_discipulo_ministerio")
//public class DiscipuloMinisterio implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cod_discipulo_ministerio")
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "cod_discipulo")
//    private Discipulo discipulo;
//
//    @ManyToOne
//    @JoinColumn(name = "cod_ministerio")
//    private Ministerio ministerio;
//
//    public DiscipuloMinisterio(Discipulo discipulo, Ministerio ministerio) {
//        this.discipulo = discipulo;
//        this.ministerio = ministerio;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        DiscipuloMinisterio that = (DiscipuloMinisterio) o;
//
//        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return getId() != null ? getId().hashCode() : 0;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Discipulo getDiscipulo() {
//        return discipulo;
//    }
//
//    public void setDiscipulo(Discipulo discipulo) {
//        this.discipulo = discipulo;
//    }
//
//    public Ministerio getMinisterio() {
//        return ministerio;
//    }
//
//    public void setMinisterio(Ministerio ministerio) {
//        this.ministerio = ministerio;
//    }
//}
