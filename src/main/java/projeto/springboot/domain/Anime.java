package projeto.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor //cria um construtor com todos os atributos.
@Data // cria os métodos get e set e outros.
public class Anime {

    private Long id;
    private String nome;
    public Anime() {
    }
}
