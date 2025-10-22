package br.edu.uniesp.softfact.aluno;

import br.edu.uniesp.softfact.aluno.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    public AlunoResponseDTO criar(@RequestBody @Valid AlunoCreateDTO dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}")
    public AlunoResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid AlunoUpdateDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public Page<AlunoResponseDTO> listar(@RequestParam(required = false) String q, Pageable pageable) {
        return service.listar(q, pageable);
    }
}
