package br.org.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.repository.LancamentoVendasRepository;
import br.org.serratec.model.LancamentoVendas;

@Service
public class LancamentoVendasService {
    
    @Autowired
    private LancamentoVendasRepository lancamentoVendasRepository;

    public List<LancamentoVendas> getLancamentoVendasList() {
        return lancamentoVendasRepository.findAll();
    }

    public LancamentoVendas inserir(LancamentoVendas lv) {
        return lancamentoVendasRepository.save(lv);
    }
}
