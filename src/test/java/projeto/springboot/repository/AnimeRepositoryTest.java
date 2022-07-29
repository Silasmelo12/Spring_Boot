package projeto.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import projeto.springboot.domain.Anime;

@DataJpaTest
@DisplayName("Testes para anime repository")
class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    @Test
    @DisplayName("Save persists anime quando sucesso")
    void save_PersistAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.animeRepository.save(animeToBeSaved);
        Assertions.assertNotNull(animeSaved);
        Assertions.assertNotNull(animeSaved.getId());
        Assertions.assertEquals(animeSaved.getNome(),animeToBeSaved.getNome());
    }

    private Anime createAnime(){
        return Anime.builder()
                .nome("naruto")
                .build();
    }
}