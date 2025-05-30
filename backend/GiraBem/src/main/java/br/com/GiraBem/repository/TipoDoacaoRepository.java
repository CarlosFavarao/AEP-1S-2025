package br.com.GiraBem.repository;

import br.com.GiraBem.model.PontoColetaModel;
import br.com.GiraBem.model.TipoDoacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDoacaoRepository extends JpaRepository<TipoDoacaoModel, Long> {
}
