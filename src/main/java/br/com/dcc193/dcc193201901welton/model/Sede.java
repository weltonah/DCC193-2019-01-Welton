package br.com.dcc193.dcc193201901welton.model;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "refSede")
    private List<Atividade> atividades ;

    @OneToMany(mappedBy = "refSede")
    private List<Menbro> menbro ;

    public Sede() {
    }

    public Sede(String nome, String UF, String cidade, String bairro, String telefone, String enderecoWeb, List<Atividade> atividades, List<Menbro> menbro) {
        this.nome = nome;
        this.UF = UF;
        this.cidade = cidade;
        this.bairro = bairro;
        this.telefone = telefone;
        this.enderecoWeb = enderecoWeb;
        this.atividades = atividades;
        this.menbro = menbro;
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

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public List<Menbro> getMenbro() {
        return menbro;
    }

    public void setMenbro(List<Menbro> menbro) {
        this.menbro = menbro;
    }

    public int getHorasTotais() {
        return this.atividades.stream().map(Atividade::getHorasTotais).mapToInt(Integer::intValue).sum();
    }
    

}
