package projeto.springboot.util;

import projeto.springboot.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved(){
        return Anime.builder()
                .nome("Naruto")
                .build();
    }

    public static Anime createValidAnime(){
        return Anime.builder()
                .nome("Naruto")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdateAnime(){
        return Anime.builder()
                .nome("DBZ")
                .id(1L)
                .build();
    }
}
