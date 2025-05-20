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

    public CidadeModel atualizar(CidadeModel cidade){
        return cidadeRepository.save(cidade);
    }

    public void deletar(Long id) {
        cidadeRepository.deleteById(id);
    }
}
