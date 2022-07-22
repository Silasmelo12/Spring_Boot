package projeto.springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.springboot.domain.Anime;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

@Service //regra de negócios
public class AnimeService {
    //implements AnimeRepository
    //private final AnimeRepository AnimeRepository;

    private static List<Anime> animes;

    static {

        animes = new ArrayList<>();
        animes.add(new Anime(1L,"DBZ"));
        animes.add(new Anime(2L,"Naruto"));
        animes.add(new Anime(3L,"One Peace"));
        animes.add(new Anime(4L, "Medabots"));
    }
    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        //return animes.get((int)id);
        return animes.stream()
                .filter(item->item.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Anime not found"));
    }

    public Anime save(Anime anime){
        anime.setId(ThreadLocalRandom.current().nextLong(5,100000));
        animes.add(anime);
        return anime;
    }

    public void delete(long id){
        animes.remove(findById(id));
    }


    public Anime replace(Anime anime) {

        int index = animes.indexOf(findById(anime.getId()));
        animes.set(index,anime);
        return anime;
    }
}
