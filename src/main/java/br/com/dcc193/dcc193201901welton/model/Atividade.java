package br.com.dcc193.dcc193201901welton.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Atividade {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    long id;

    private String titulo;
    private String descricao;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataInicial;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataFinal;

    @ManyToOne
    private Sede sede;

    public Atividade() {
    }

    public Atividade(String titulo, String descricao, Date dataInicial, Date dataFinal, Sede sede) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.sede = sede;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataInicialStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDataInicial());
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public String getDataFinalStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDataFinal());
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
