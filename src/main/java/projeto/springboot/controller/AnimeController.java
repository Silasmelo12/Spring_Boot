package projeto.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projeto.springboot.domain.Anime;
import projeto.springboot.requests.AnimePostRequestBody;
import projeto.springboot.requests.AnimePutRequestBody;
import projeto.springboot.service.AnimeService;
import projeto.springboot.util.DateUtil;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    //ResponseEntity retorna tanto a resposta quanto o estado atuall
    @GetMapping //sem o path = "list"
    @ResponseBody //Rest
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @GetMapping(path = "find")
    @ResponseBody
    public ResponseEntity<List<Anime>> findByNome(@RequestParam String nome) {
        return new ResponseEntity<>(animeService.findByNome(nome), HttpStatus.OK);
    }

    //Quando há apenas um método POST no Controller então o Spring encontra automaticamente

    //@RequestBody recebe um corpo de requisição, um objeto.
    // Se caso os parametros forem iguais, então automaticamente será o proprio objeto
    @PostMapping
    @ResponseBody
    public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody) {
        System.out.println("o qie está vindo: " + animePostRequestBody.getNome());
        return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
    }

    //@PathVariable pega um valor passando na url
    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable long id) {
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
        animeService.replace(animePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
