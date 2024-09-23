package br.com.fiap.ms_aluno.service;

import br.com.fiap.ms_aluno.dto.AlunoDTO;
import br.com.fiap.ms_aluno.model.Aluno;
import br.com.fiap.ms_aluno.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Transactional(readOnly = true)
    public List<AlunoDTO> findAll() {
        return repository.findAll().stream()
                .map(AlunoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado")
        );
        return new AlunoDTO(aluno);
    }

    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {
        Aluno entity = new Aluno();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }

    private void copyEntityToDto(Aluno entity, AlunoDTO dto) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setRm(dto.getRm());
        entity.setStatus(dto.getStatus());
        entity.setTurma(dto.getTurma());
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        try {
            Aluno entity = repository.getReferenceById(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new AlunoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Recurso não encontrado");
        }
        repository.deleteById(id);
    }
}
