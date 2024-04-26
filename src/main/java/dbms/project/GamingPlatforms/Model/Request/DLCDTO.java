package dbms.project.GamingPlatforms.Model.Request;

import dbms.project.GamingPlatforms.Model.Game;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DLCDTO {
    private String name;

    private String description;

    private int price;

    private Game game;
}
