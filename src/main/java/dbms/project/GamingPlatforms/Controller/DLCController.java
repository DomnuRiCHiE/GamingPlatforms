package dbms.project.GamingPlatforms.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dbms.project.GamingPlatforms.Model.DLC;
import dbms.project.GamingPlatforms.Model.Request.DLCDTO;
import dbms.project.GamingPlatforms.Repository.DLCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dlc")
public class DLCController {
    @Autowired
    DLCRepository repository;

    @Autowired
    ObjectMapper mapper;

    @GetMapping()
    public List<DLC> getAllDLCs() {
        return repository.findAll();
    }

    @PostMapping()
    public void addDLC(@RequestBody DLCDTO dlc) {
        DLC mappedDLC = mapper.convertValue(dlc, DLC.class);
        repository.save(mappedDLC);
    }

    @DeleteMapping("/{id}")
    public void removeDLC(@PathVariable Long id) {
        DLC existingDLC = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DLC with id " + id + " not found"));
        repository.delete(existingDLC);
    }

    @PutMapping("/{id}")
    public DLC updateDLC(@PathVariable Long id, @RequestBody DLCDTO updatedDLC) {
        DLC existingDLC = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DLC with id " + id + " not found"));
        existingDLC.setName(updatedDLC.getName());
        existingDLC.setDescription(updatedDLC.getDescription());
        existingDLC.setPrice(updatedDLC.getPrice());
        //TODO: Find a fix for update function
        //existingDLC.setGame(updatedDLC.getGame());
        return repository.save(existingDLC);
    }
}
