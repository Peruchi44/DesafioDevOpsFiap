package com.java.projetofiap.desafiodevops.service;

import com.java.projetofiap.desafiodevops.model.RegistroEsg;
import com.java.projetofiap.desafiodevops.repository.RegistroEsgRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroEsgService {

    private final RegistroEsgRepository repository;

    public RegistroEsgService(RegistroEsgRepository repository) {
        this.repository = repository;
    }

    public List<RegistroEsg> listarTodos() {
        return repository.findAll();
    }

    public Optional<RegistroEsg> buscarPorId(String id) {
        return repository.findById(id);
    }

    public RegistroEsg salvar(RegistroEsg registro) {
        // Cálculo simples de pegada de carbono padrão se não fornecido
        if (registro.getEmissoesCo2Kg() == null && registro.getConsumoKwh() != null) {
            registro.setEmissoesCo2Kg(registro.getConsumoKwh() * 0.085); // fator médio
        }
        return repository.save(registro);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}