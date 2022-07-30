package projeto.springboot.util;

import projeto.springboot.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {

    public static AnimePutRequestBody createAnimePutRequestBody(){
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .nome(AnimeCreator.createValidUpdateAnime().getNome())
                .build();
    }
}
