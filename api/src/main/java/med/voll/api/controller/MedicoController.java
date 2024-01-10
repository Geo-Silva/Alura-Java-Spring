package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
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
        return repository.findAll(paginacao).map(DadosListagemMedico::new);

    }

}
