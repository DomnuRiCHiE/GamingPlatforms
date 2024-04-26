package dbms.project.GamingPlatforms.Model.Request;

import lombok.*;
import java.util.Date;

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
}
