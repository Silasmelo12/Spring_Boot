package projeto.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor //cria um construtor com todos os atributos.
@Data // cria os métodos get e set e outros.
@Entity
@NoArgsConstructor
@Builder
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "o nome do anime não pode ser nulo")
    @NotNull(message = "o nome do anime não pode ser nulo")
    private String nome;
}
