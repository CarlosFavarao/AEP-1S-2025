package br.com.GiraBem.service;

import br.com.GiraBem.DTO.PontoColetaResponseDTO;
import br.com.GiraBem.model.TipoDoacaoModel;
import br.com.GiraBem.repository.CidadeRepository;
import br.com.GiraBem.repository.PontoColetaRepository;
import br.com.GiraBem.model.CidadeModel;
import br.com.GiraBem.model.PontoColetaModel;
import br.com.GiraBem.repository.TipoDoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PontoColetaService {
    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    @Autowired
    private TipoDoacaoRepository tipoDoacaoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    //DTO (minha primeira vez usando, pode dar ruim)
    private PontoColetaResponseDTO toResponseDTO(PontoColetaModel model){
        return new PontoColetaResponseDTO(
                model.getId(), model.getNome(), model.getEndereco(), model.getTipoDoacao().getNome(),
                model.getCidade().getNome(), model.getDiasFuncionamento(),
                model.getHorarioFuncionamento());
    }

    //Listagem e filtragem
    public List<PontoColetaResponseDTO> filtrarDTOporTipoECidade(Long tipoDoacaoId, Long cidadeId) {
        return pontoColetaRepository.findByTipoDoacaoIdAndCidadeId(tipoDoacaoId, cidadeId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList()); //O único que o usuário verá, pelo menos atualmente
    }

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
    public PontoColetaModel salvarPonto(PontoColetaModel ponto) {
        // Busca entidades existentes no banco
        TipoDoacaoModel tipo = tipoDoacaoRepository.findById(ponto.getTipoDoacao().getId())
                .orElseThrow(() -> new RuntimeException("Tipo de doação não encontrado"));

        CidadeModel cidade = cidadeRepository.findById(ponto.getCidade().getId())
                .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

        // Substitui os objetos enviados pelo Postman pelos objetos gerenciados pelo JPA
        ponto.setTipoDoacao(tipo);
        ponto.setCidade(cidade);

        return pontoColetaRepository.save(ponto);
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

            CidadeModel cidade = cidadeRepository.findById(dadosAtualizados.getCidade().getId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));

            TipoDoacaoModel tipo = tipoDoacaoRepository.findById(dadosAtualizados.getTipoDoacao().getId())
                    .orElseThrow(() -> new RuntimeException("Tipo de doação não encontrado"));

            ponto.setCidade(cidade);
            ponto.setTipoDoacao(tipo);

            return pontoColetaRepository.save(ponto);
        });
    }
}
