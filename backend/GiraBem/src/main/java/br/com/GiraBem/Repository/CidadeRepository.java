package br.com.GiraBem.Repository;

import br.com.GiraBem.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {

}
