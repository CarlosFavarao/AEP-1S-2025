package br.com.GiraBem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
    @JoinColumn (name = "tipo_doacao_id", nullable = false)
    private TipoDoacaoModel tipoDoacaoId;

    @ManyToOne
    @JoinColumn (name = "cidade_id", nullable = false)
    private CidadeModel cidadeId;

}
