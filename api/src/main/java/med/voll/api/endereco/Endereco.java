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
}
