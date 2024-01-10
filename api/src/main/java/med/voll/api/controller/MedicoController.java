package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired //injeção de dependencias, vai instanciar e passar o atributo na classe controller
    private MedicoRepository repository;

    @PostMapping
    @Transactional //por ser um método que escreve dados no db, precisamos ter uma transação ativa
                    //assim, toda vez que for feita alguma alteração no db, o spring irá fazer a
                    //inserção e remoção, caso dê algum erro. Isso facilita, já que não terá que
                    //ser feito manualmente
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        //precisamos filtrar o retorno, logo, passamos o DTO
        //como o método findAll não é válido para o DTO, fazemos um mapping e passamos para um page
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfo(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exluir(@PathVariable Long id){

        var medico = repository.getReferenceById(id);
        medico.excluir();

    }

    @PutMapping("/{id}")
    @Transactional
    public void reativar(@PathVariable Long id){

        var medico = repository.getReferenceById(id);
        medico.reativar();

    }

}
