package br.com.GiraBem.service;

import br.com.GiraBem.repository.CidadeRepository;
import br.com.GiraBem.model.CidadeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeModel salvar(CidadeModel cidade){
        return cidadeRepository.save(cidade);
    }

    public List<CidadeModel> listarCidades(){
        return cidadeRepository.findAll();
    }

    public Optional<CidadeModel> buscarPorId(Long id){
        return cidadeRepository.findById(id);
    }

    public Optional<CidadeModel> atualizar(Long id, CidadeModel dadosAtualizados){
        return cidadeRepository.findById(id).map(cidade -> {
            cidade.setNome(dadosAtualizados.getNome());
            return cidadeRepository.save(cidade);
        });
    }

    public boolean deletar(Long id) {
        if (cidadeRepository.existsById(id)){
            cidadeRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
