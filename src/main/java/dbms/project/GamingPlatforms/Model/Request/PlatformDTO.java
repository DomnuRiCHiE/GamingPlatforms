package dbms.project.GamingPlatforms.Model.Request;

import dbms.project.GamingPlatforms.Model.Game;
import lombok.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatformDTO {
    private String name;

    private Date dateEstablished;

    private Set<Game> games;
}
