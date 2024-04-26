package dbms.project.GamingPlatforms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbms.project.GamingPlatforms.Model.Game;
import dbms.project.GamingPlatforms.Model.Request.GameDTO;
import dbms.project.GamingPlatforms.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    GameRepository repository;

    @Autowired
    ObjectMapper mapper;

    @GetMapping()
    public List<Game> getAllGames() {
        return repository.findAll();
    }

    @PostMapping()
    public void addGame(@RequestBody GameDTO game) {
        Game mappedGame = mapper.convertValue(game, Game.class);
        repository.save(mappedGame);
    }

    @DeleteMapping("/{id}")
    public void removeGame(@PathVariable Long id) {
        Game existingGame = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with id " + id + " not found"));
        repository.delete(existingGame);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody GameDTO updatedGame) {
        Game existingGame = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with id " + id + " not found"));
        existingGame.setName(updatedGame.getName());
        existingGame.setPrice(updatedGame.getPrice());
        existingGame.setReleaseDate(updatedGame.getReleaseDate());
        existingGame.setAgeRestriction(updatedGame.getAgeRestriction());
        existingGame.setGameFileSizeInGB(updatedGame.getGameFileSizeInGB());
        existingGame.setAchievementNumber(updatedGame.getAchievementNumber());
        //TODO: Find a fix for update function
        //existingGame.setDlcs(updatedGame.getDlcs);
        //existingGame.setGenres(updatedGame.getGenres());
        //existingGame.setPlatforms(updatedGame.getPlatforms());
        return repository.save(existingGame);
    }
}
