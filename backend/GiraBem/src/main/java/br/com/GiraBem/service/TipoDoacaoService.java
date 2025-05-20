package br.com.GiraBem.service;

import br.com.GiraBem.repository.TipoDoacaoRepository;
import br.com.GiraBem.model.TipoDoacaoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDoacaoService {
    @Autowired
    private TipoDoacaoRepository tipoDoacaoRepository;

    public List<TipoDoacaoModel> listarTiposDoacao(){
        return tipoDoacaoRepository.findAll();
    }
}
