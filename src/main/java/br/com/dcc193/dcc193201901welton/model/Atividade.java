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
    private int assistencial = 0;
    private int juridica = 0;
    private int financeira = 0;
    private int executiva = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sede refSede;

    public Atividade() {
    }

    public Atividade(String titulo, String descricao, Date dataInicial, Date dataFinal, int assistencial, int juridica, int financeira, int executiva, Sede refSede) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.assistencial = assistencial;
        this.juridica = juridica;
        this.financeira = financeira;
        this.executiva = executiva;
        this.refSede = refSede;
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
    public Sede getRefSede() {
        return refSede;
    }

    public void setRefSede(Sede refSede) {
        this.refSede = refSede;
    }

    public int getAssistencial() {
        return assistencial;
    }

    public void setAssistencial(int assistencial) {
        this.assistencial = assistencial;
    }

    public int getJuridica() {
        return juridica;
    }

    public void setJuridica(int juridica) {
        this.juridica = juridica;
    }

    public int getFinanceira() {
        return financeira;
    }

    public void setFinanceira(int financeira) {
        this.financeira = financeira;
    }

    public int getExecutiva() {
        return executiva;
    }

    public void setExecutiva(int executiva) {
        this.executiva = executiva;
    }

    public int getHorasTotais(){
        return executiva + juridica + assistencial+ financeira;
    }
}
