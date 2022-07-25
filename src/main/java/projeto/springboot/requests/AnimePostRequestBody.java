package projeto.springboot.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotNull(message = "o nome do anime não pode ser branco")
    @NotEmpty(message = "o nome do anime não pode ser branco")
    private String nome;
}
