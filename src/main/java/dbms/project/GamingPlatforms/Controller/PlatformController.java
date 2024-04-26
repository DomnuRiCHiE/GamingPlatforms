package dbms.project.GamingPlatforms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbms.project.GamingPlatforms.Model.Platform;
import dbms.project.GamingPlatforms.Model.Request.PlatformDTO;
import dbms.project.GamingPlatforms.Repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platform")
public class PlatformController {
    @Autowired
    PlatformRepository repository;

    @Autowired
    ObjectMapper mapper;

    @GetMapping()
    public List<Platform> getAllPlatforms() {
        return repository.findAll();
    }

    @PostMapping()
    public void addPlatform(@RequestBody PlatformDTO platform) {
        Platform mappedPlatform = mapper.convertValue(platform, Platform.class);
        repository.save(mappedPlatform);
    }

    @DeleteMapping("/{id}")
    public void removeGame(@PathVariable Long id) {
        Platform existingPlatform = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Platform with id " + id + " not found"));
        repository.delete(existingPlatform);
    }

    @PutMapping("/{id}")
    public Platform updatePlatform(@PathVariable Long id, @RequestBody PlatformDTO updatedPlatform) {
        Platform existingPlatform = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game with id " + id + " not found"));
        existingPlatform.setName(updatedPlatform.getName());
        existingPlatform.setDateEstablished(updatedPlatform.getDateEstablished());
        //TODO: Find a fix for update function
        //existingPlatform.setGames(updatedPlatform.setGames);
        return repository.save(existingPlatform);
    }
}
