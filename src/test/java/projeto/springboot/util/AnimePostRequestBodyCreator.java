package projeto.springboot.util;

import projeto.springboot.requests.AnimePostRequestBody;

public class AnimePostRequestBodyCreator {

    public static AnimePostRequestBody createAnimePostRequestBody(){

        return new AnimePostRequestBody(AnimeCreator.createAnimeToBeSaved().getNome());
    }
}
