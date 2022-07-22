package projeto.springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import projeto.springboot.domain.Anime;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //regra de negócios
public class AnimeService {
    //implements AnimeRepository
    //private final AnimeRepository AnimeRepository;

    List<Anime> animes = Arrays.asList(new Anime(3L,"One Peace"),new Anime(2L,"Naruto"),new Anime(1L,"DBZ"),new Anime(4L, "Medabots"));

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



}
