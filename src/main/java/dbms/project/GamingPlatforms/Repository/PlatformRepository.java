package dbms.project.GamingPlatforms.Repository;

import dbms.project.GamingPlatforms.Model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {}
