package br.com.GiraBem.DTO;

public class PontoColetaResponseDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String tipoDoacao;
    private String cidade;
    private String diasFuncionamento;
    private String horarioFuncionamento;

    public PontoColetaResponseDTO(Long id, String nome, String endereco, String tipoDoacao, String cidade, String diasFuncionamento, String horarioFuncionamento) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDoacao = tipoDoacao;
        this.cidade = cidade;
        this.diasFuncionamento = diasFuncionamento;
        this.horarioFuncionamento = horarioFuncionamento;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTipoDoacao() {
        return tipoDoacao;
    }

    public String getCidade() {
        return cidade;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }
}
