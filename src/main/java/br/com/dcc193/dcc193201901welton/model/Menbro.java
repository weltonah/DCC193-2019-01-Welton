package br.com.dcc193.dcc193201901welton.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Menbro {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    long id;

    private String nome;
    private String funcao;
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataEntrada;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataSaida;

    @ManyToOne
    private Sede refSede;

    public Menbro() {

    }

    public Menbro(String nome, String funcao, String email, Date dataEntrada, Date dataSaida, Sede refSede) {
        this.nome = nome;
        this.funcao = funcao;
        this.email = email;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.refSede = refSede;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }
    public String getDataEntradaStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDataEntrada());
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getDataSaidaStr() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(getDataSaida());
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Sede getRefSede() {
        return refSede;
    }

    public void setRefSede(Sede refSede) {
        this.refSede = refSede;
    }
}
