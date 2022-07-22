package projeto.springboot.repository;

import projeto.springboot.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> listAll();

}
