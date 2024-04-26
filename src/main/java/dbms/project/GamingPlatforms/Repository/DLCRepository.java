package dbms.project.GamingPlatforms.Repository;

import dbms.project.GamingPlatforms.Model.DLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {}
