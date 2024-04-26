package dbms.project.GamingPlatforms.Model.Request;

import dbms.project.GamingPlatforms.Model.DLC;
import dbms.project.GamingPlatforms.Model.Genre;
import dbms.project.GamingPlatforms.Model.Platform;
import lombok.*;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameDTO {
    private String name;

    private int price;

    private Date releaseDate;

    private int ageRestriction;

    private int gameFileSizeInGB;

    private int achievementNumber;

    private Set<DLC> dlcs;

    private Set<Genre> genres;

    private Set<Platform> platforms;
}
