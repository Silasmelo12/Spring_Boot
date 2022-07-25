package projeto.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.springboot.domain.Anime;

import java.util.List;

// conexão direta com o banco de dados, o CRUD
public interface AnimeRepository extends JpaRepository<Anime,Long> {


}
