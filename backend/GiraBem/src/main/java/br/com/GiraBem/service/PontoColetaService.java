package br.com.GiraBem.service;

import br.com.GiraBem.repository.PontoColetaRepository;
import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.model.PontoColetaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoColetaService {
    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    //Listagem e filtragem
    public List<PontoColetaModel> listarTodos(){
        return pontoColetaRepository.findAll();
    }

    public List<PontoColetaModel> filtrarPorTipoECidade(Long tipoDoacaoId, Long cidadeId) {
        return pontoColetaRepository.findByTipoDoacaoIdAndCidadeId(tipoDoacaoId, cidadeId);
    }

    public List<CidadeModel> listarCidadesPorTipo(Long tipoDoacaoId){
        return pontoColetaRepository.findCidadesComPontoPorTipo(tipoDoacaoId);
    }

    public Optional<PontoColetaModel> buscarPontoPorId(Long id){
        return pontoColetaRepository.findById(id);
    }

    //Resto do CRUD
    public PontoColetaModel salvarPonto(PontoColetaModel pontoColeta){
        return pontoColetaRepository.save(pontoColeta);
    }

    public boolean deletarPonto(Long id){
        if (pontoColetaRepository.existsById(id)){
            pontoColetaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<PontoColetaModel> atualizar(Long id, PontoColetaModel dadosAtualizados) {
        return pontoColetaRepository.findById(id).map(ponto -> {
            ponto.setNome(dadosAtualizados.getNome());
            ponto.setEndereco(dadosAtualizados.getEndereco());
            ponto.setCidade(dadosAtualizados.getCidade());
            ponto.setTipoDoacao(dadosAtualizados.getTipoDoacao());
            return pontoColetaRepository.save(ponto);
        });
    }
}
