package br.com.GiraBem.service;

import br.com.GiraBem.repository.CidadeRepository;
import br.com.GiraBem.model.CidadeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeModel> listarCidades(){
        return cidadeRepository.findAll();
    }
}
