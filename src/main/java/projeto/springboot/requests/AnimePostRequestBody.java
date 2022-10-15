package projeto.springboot.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
    @NotNull(message = "o nome do anime não pode ser branco")
    @NotEmpty(message = "o nome do anime não pode ser nulo")
    private String nome;

    public AnimePostRequestBody() {
    }

    @JsonCreator
    public AnimePostRequestBody(String nome) {
        this.nome = nome;
    }
}
