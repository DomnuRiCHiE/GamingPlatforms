package dbms.project.GamingPlatforms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbms.project.GamingPlatforms.Model.Genre;
import dbms.project.GamingPlatforms.Model.Request.GenreDTO;
import dbms.project.GamingPlatforms.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    GenreRepository repository;

    @Autowired
    ObjectMapper mapper;

    @GetMapping()
    public List<Genre> getAllGenres() {
        return repository.findAll();
    }

    @PostMapping()
    public void addGenre(@RequestBody GenreDTO genre) {
        Genre mappedGenre = mapper.convertValue(genre, Genre.class);
        repository.save(mappedGenre);
    }

    @DeleteMapping("/{id}")
    public void removeGenre(@PathVariable Long id) {
        Genre existingGenre = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre with id " + id + " not found"));
        repository.delete(existingGenre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody GenreDTO updatedGenre) {
        Genre existingGenre = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre with id " + id + " not found"));
        existingGenre.setName(updatedGenre.getName());
        existingGenre.setGames(updatedGenre.getGames());
        return repository.save(existingGenre);
    }
}
