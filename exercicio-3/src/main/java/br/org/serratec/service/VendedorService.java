package br.org.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.repository.VendedorAutonomoRepository;
import br.org.serratec.model.VendedorAutonomo;

@Service
public class VendedorService {
    
    @Autowired
    private VendedorAutonomoRepository vendedorAutonomoRepository;

    public List<VendedorAutonomo> listar() {
        return vendedorAutonomoRepository.findAll();
    }

    public VendedorAutonomo inserir(VendedorAutonomo v) {
        return vendedorAutonomoRepository.save(v);
    }
}
