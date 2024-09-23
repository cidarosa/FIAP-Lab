package br.com.fiap.ms_aluno.controller;

import br.com.fiap.ms_aluno.dto.AlunoDTO;
import br.com.fiap.ms_aluno.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll(){
        List<AlunoDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

}
