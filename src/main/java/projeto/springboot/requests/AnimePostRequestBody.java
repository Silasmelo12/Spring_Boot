package projeto.springboot.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
//@Builder
public class AnimePostRequestBody {
    @NotNull(message = "o nome do anime não pode ser branco")
    @NotEmpty(message = "o nome do anime não pode ser nulo")
    private String nome;
}
