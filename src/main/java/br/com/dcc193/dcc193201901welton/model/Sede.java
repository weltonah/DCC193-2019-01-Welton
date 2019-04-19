package br.com.dcc193.dcc193201901welton.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sede {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    long id;

    private String nome;
    private String UF;
    private String cidade;
    private String bairro;
    private String telefone;
    private String enderecoWeb;



    public Sede() {
    }

    public Sede(String nome, String UF, String cidade, String bairro, String telefone, String enderecoWeb) {
        this.nome = nome;
        this.UF = UF;
        this.cidade = cidade;
        this.bairro = bairro;
        this.telefone = telefone;
        this.enderecoWeb = enderecoWeb;
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }
}
