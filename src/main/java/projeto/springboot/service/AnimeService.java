package projeto.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.springboot.mapper.AnimeMapper;
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

    public List<Anime> listAllNonPageable() {
        return animeRepository.findAll();
    }

    public List<Anime> findByNome(String nome) {
        return animeRepository.findByNome(nome);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime não encontrado"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        System.out.println("Save: "+animePostRequestBody.getNome());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        System.out.println("Save: "+anime.getNome());
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        animeRepository.save(anime);
    }
}
