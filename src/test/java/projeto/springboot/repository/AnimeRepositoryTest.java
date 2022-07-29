package projeto.springboot.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import projeto.springboot.domain.Anime;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("Save updates anime repository")
    void save_UpdateAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        animeSaved.setNome("DBZ");

        Anime animeUpdated = this.animeRepository.save(animeToBeSaved);

        Assertions.assertNotNull(animeUpdated);
        Assertions.assertNotNull(animeUpdated.getId());
        Assertions.assertEquals(animeUpdated.getNome(),animeSaved.getNome());
    }

    @Test
    @DisplayName("Delete anime repository")
    void delete_RemovesAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        this.animeRepository.delete(animeSaved);

        Optional<Anime> byId = this.animeRepository.findById(animeSaved.getId());

        Assertions.assertFalse(byId.isPresent());
    }

    @Test
    @DisplayName("Find by name returns list of anime when successful")
    void findByName_ReturnsListOfAnime_WhenSuccessful(){
        Anime animeToBeSaved = createAnime();

        Anime animeSaved = this.animeRepository.save(animeToBeSaved);

        String name = animeSaved.getNome();

        List<Anime> animes = this.animeRepository.findByNome(name);

        Assertions.assertFalse(animes.isEmpty());
        Assertions.assertTrue(animes.contains(animeSaved));
    }

    @Test
    @DisplayName("Find by name returns empty list of anime when no anime is found")
    void findByName_ReturnsEmptyListOfAnime_WhenAnimeIsNotFound(){
        List<Anime> animes = this.animeRepository.findByNome("naruto");

        Assertions.assertTrue(animes.isEmpty());
    }

    @Test
    @DisplayName("Save throw ThrowsConstraintValidationException when name is empty")
    void save_ThrowsConstraintValidationException_WhenNameIsEmpty(){
        Anime animeToBeSaved = new Anime();
        assertThatThrownBy(()-> this.animeRepository.save(animeToBeSaved))
                .isInstanceOf(ConstraintViolationException.class);

//        assertThatExceptionOfType(ConstraintViolationException.class)
//                .isThrownBy(()->this.animeRepository.save(animeToBeSaved))
//                .withMessageContaining("o nome do anime não pode ser nulo");
    }

    private Anime createAnime(){
        return Anime.builder()
                .nome("naruto")
                .build();
    } 
}