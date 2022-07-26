package projeto.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.springboot.Mapper.AnimeMapper;
import projeto.springboot.domain.Anime;
import projeto.springboot.exception.BadRequestException;
import projeto.springboot.repository.AnimeRepository;
import projeto.springboot.requests.AnimePostRequestBody;
import projeto.springboot.requests.AnimePutRequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service //regra de negócios
public class AnimeService {
    //implements AnimeRepository

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByNome(String nome) {
        return animeRepository.findByNome(nome);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        //return animes.get((int)id);
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime não encontrado"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        anime = animeRepository.save(anime);
        System.out.println("Quem ta chegando: "+anime.getNome());
        //Anime anime = Anime.builder().nome(animePostRequestBody.getNome()).build();
        return anime;
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
