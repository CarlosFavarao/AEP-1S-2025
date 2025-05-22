package br.com.GiraBem.model;

import jakarta.persistence.*;

@Entity
@Table (name = "ponto_coleta")
public class PontoColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String endereco;

    @Column (name = "dias_funcionamento", nullable = false)
    private String diasFuncionamento;

    @Column (name = "horario_funcionamento", nullable = false)
    private String horarioFuncionamento;

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

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
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

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
}
