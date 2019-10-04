package br.com.agape.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;

@Entity
@Table(name = "tb_dia_evento")
public class DiaEvento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_dia_evento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_evento")
    private Evento evento;

    @Column(name = "dat_dia_semana")
    private Date diaSemana;

    @Column(name = "hor_abertura")
    private Time horaAbertura;

    @Column(name = "hor_encerramento")
    private Time horaEncerramento;

    public DiaEvento() {
    }

    public DiaEvento(Evento evento, Date diaSemana, Time horaAbertura, Time horaEncerramento) {
        this.evento = evento;
        this.diaSemana = diaSemana;
        this.horaAbertura = horaAbertura;
        this.horaEncerramento = horaEncerramento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaEvento diaEvento = (DiaEvento) o;
        return getId().equals(diaEvento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(Time horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public Time getHoraEncerramento() {
        return horaEncerramento;
    }

    public void setHoraEncerramento(Time horaEncerramento) {
        this.horaEncerramento = horaEncerramento;
    }

}