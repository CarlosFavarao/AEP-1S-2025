package br.com.GiraBem.service;

import br.com.GiraBem.repository.TipoDoacaoRepository;
import br.com.GiraBem.model.TipoDoacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDoacaoService {
    @Autowired
    private TipoDoacaoRepository tipoDoacaoRepository;

    //CRUD padrão
    public TipoDoacaoModel salvarTipoDoacao(TipoDoacaoModel tipoDoacao){
        return tipoDoacaoRepository.save(tipoDoacao);
    }

    public List<TipoDoacaoModel> listarTiposDoacao(){
        return tipoDoacaoRepository.findAll();
    }

    public Optional<TipoDoacaoModel> buscarTiposDoacaoPorId(Long id){
        return tipoDoacaoRepository.findById(id);
    }

    public Optional<TipoDoacaoModel> atualizarTipoDoacao(Long id, TipoDoacaoModel tipoDoacao){
        return tipoDoacaoRepository.findById(id).map(tipoExistente -> {
            tipoExistente.setNome(tipoDoacao.getNome());
            return  tipoDoacaoRepository.save(tipoExistente);
        });
    }

    public boolean deletar(Long id) {
        if (tipoDoacaoRepository.existsById(id)){
            tipoDoacaoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
