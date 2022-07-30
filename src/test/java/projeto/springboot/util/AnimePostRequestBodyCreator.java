package projeto.springboot.util;

import projeto.springboot.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createAnimePostRequestBody(){
        return AnimePostRequestBody.builder()
                .nome(AnimeCreator.createAnimeToBeSaved().getNome())
                .build();
    }
}
