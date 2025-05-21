package br.com.GiraBem.model;

import jakarta.persistence.*;

@Entity
@Table (name = "ponto_coleta")
public class PontoColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "tipo_doacao_id", nullable = false)
    private TipoDoacaoModel tipoDoacao;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private CidadeModel cidade;

    public PontoColetaModel() {};

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public TipoDoacaoModel getTipoDoacao() {
        return tipoDoacao;
    }

    public CidadeModel getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTipoDoacao(TipoDoacaoModel tipoDoacao) {
        this.tipoDoacao = tipoDoacao;
    }

    public void setCidade(CidadeModel cidade) {
        this.cidade = cidade;
    }
}
