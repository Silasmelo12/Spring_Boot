package projeto.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import projeto.springboot.domain.Anime;
import projeto.springboot.requests.AnimePostRequestBody;
import projeto.springboot.requests.AnimePutRequestBody;

@Mapper
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}