package br.com.GiraBem.repository;

import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.model.PontoColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PontoColetaRepository extends JpaRepository<PontoColetaModel, Long> {

    List<PontoColetaModel> findByTipoDoacaoIdAndCidadeId(Long tipoDoacaoId, Long cidadeId);

    @Query("SELECT DISTINCT p.cidade FROM PontoColetaModel p WHERE p.tipo_doacao.id = :tipoId")
    List<CidadeModel> findCidadesComPontoPorTipo(@Param("tipoId") Long tipoId);
}

