package dbms.project.GamingPlatforms.Service;

import dbms.project.GamingPlatforms.Repository.DLCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DLCService {
    private final DLCRepository dlcRepository;

    @Autowired
    public DLCService(DLCRepository dlcRepository) {
        this.dlcRepository = dlcRepository;
    }
}
