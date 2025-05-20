package br.com.GiraBem.service;

import br.com.GiraBem.repository.PontoColetaRepository;
import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.model.PontoColetaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoColetaService {
    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    public List<PontoColetaModel> listarTodos(){
        return pontoColetaRepository.findAll();
    }

    public List<PontoColetaModel> filtrarPorTipoECidade(Long tipoDoacaoId, Long cidadeId) {
        return pontoColetaRepository.findByTipoDoacaoIdAndCidadeId(tipoDoacaoId, cidadeId);
    }

    public List<CidadeModel> listarCidadesPorTipo(Long tipoDoacaoId){
        return pontoColetaRepository.findCidadesComPontoPorTipo(tipoDoacaoId);
    }
}
