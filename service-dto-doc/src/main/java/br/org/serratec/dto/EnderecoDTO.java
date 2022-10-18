package br.org.serratec.dto;

import br.org.serratec.model.Endereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EnderecoDTO {

    @ApiModelProperty(value = "Identifica de uma cep")
    private String cep;
    @ApiModelProperty(value = "Identifica uma rua")
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    @ApiModelProperty(value = "Identifica o estado")
    private String uf;

    public EnderecoDTO(Endereco endereco) {
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
    }

}
