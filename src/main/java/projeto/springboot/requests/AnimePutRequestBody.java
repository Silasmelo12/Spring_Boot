package projeto.springboot.requests;

import lombok.Data;

@Data
//@Builder
public class AnimePutRequestBody {
    private Long id;
    private String nome;
}
