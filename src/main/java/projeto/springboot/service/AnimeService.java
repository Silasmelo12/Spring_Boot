package projeto.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.springboot.Mapper.AnimeMapper;
import projeto.springboot.domain.Anime;
import projeto.springboot.exception.BadRequestException;
import projeto.springboot.repository.AnimeRepository;
import projeto.springboot.requests.AnimePostRequestBody;
import projeto.springboot.requests.AnimePutRequestBody;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service //regra de negócios
public class AnimeService {
    //implements AnimeRepository

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public List<Anime> findByNome(String nome) {
        return animeRepository.findByNome(nome);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        //return animes.get((int)id);
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime não encontrado"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        System.out.println("o qie chegou: " + anime.getNome());
        //Anime anime = Anime.builder().nome(animePostRequestBody.getNome()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        /*
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .nome(animePutRequestBody.getNome())
                .build();

        */
        animeRepository.save(anime);
    }
}
