package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING) //define como os valores do enum serão alocados no db
                                //STRING para texto, ORDINAL para sequência númerica
                                //assim o db sabe como lidar e armazenar os valores do ENUM
    private Especialidade especialidade;

    @Embedded //faz o JPA não criar uma tabela separada para o endereco, mas anexa ela e seus valores
                //a tabela do médico, a tabela que ela esta
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }

    public void atualizarInfo(DadosAtualizacaoMedico dados){

        if(dados.nome() != null) {

            this.nome = dados.nome();

        }

        if(dados.telefone() != null){

            this.telefone = dados.telefone();

        }

        if(dados.endereco() != null){

            this.endereco.atualizarInfo(dados.endereco());

        }

    }

    public void excluir() {

        this.ativo = false;

    }

    public void reativar(){

        this.ativo = true;

    }
}
