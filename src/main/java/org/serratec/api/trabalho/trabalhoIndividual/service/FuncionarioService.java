package org.serratec.api.trabalho.trabalhoIndividual.service;

import org.serratec.api.trabalho.trabalhoIndividual.domain.Funcionario;
import org.serratec.api.trabalho.trabalhoIndividual.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario listarUm(Long id) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        if (funcionarioOpt.isPresent()) {
            return funcionarioOpt.get();
        }
        return null;
    }

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Funcionario editar(Long id, Funcionario funcionario) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        if (funcionarioOpt.isPresent()) {
            Funcionario f = funcionarioOpt.get();
            f.setNome(funcionario.getNome());
            f.setEndereco(funcionario.getEndereco());
            funcionarioRepository.save(f);
            return f;
        }
        return null;
    }

    public boolean deletar(Long id) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);
        if (funcionarioOpt.isPresent()) {
            funcionarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
