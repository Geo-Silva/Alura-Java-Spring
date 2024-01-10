package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable //permite a classe ser usada como @Embedded em outros lugares, fazendo não ser criada uma tabela
            //só para ela, mas sim, juntar seus valores com a da tabela a qual está relacionada
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {

        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();

        if(dados.complemento() == null ||
            dados.complemento() == ""){

            this.complemento = "N/A";

        }else{

            this.complemento = dados.complemento();

        }

        if(dados.numero() == null ||
            dados.numero() == ""){

            this.numero = "N/A";

        }else{

            this.numero = dados.numero();

        }
    }

    public void atualizarInfo(DadosEndereco dados) {

        if(dados.logradouro() != null){

            this.logradouro = dados.logradouro();

        }

        if(dados.bairro() != null){

            this.bairro = dados.bairro();

        }

        if(dados.cep() != null){

            this.cep = dados.cep();

        }

        if(dados.uf() != null){

            this.uf = dados.uf();

        }

        if(dados.cidade() != null){

            this.cidade = dados.cidade();

        }

        if(dados.numero() != null){

            this.numero = dados.numero();

        }

        if(dados.complemento() != null){

            this.complemento = dados.complemento();

        }

    }
}
