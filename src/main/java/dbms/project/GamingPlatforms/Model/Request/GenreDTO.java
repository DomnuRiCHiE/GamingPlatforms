package dbms.project.GamingPlatforms.Model.Request;

import dbms.project.GamingPlatforms.Model.Game;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreDTO {
    private String name;

    private Set<Game> games;
}
