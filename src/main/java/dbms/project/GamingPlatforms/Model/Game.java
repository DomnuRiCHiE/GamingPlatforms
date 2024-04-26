package dbms.project.GamingPlatforms.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Game {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private Date releaseDate;

    @Column
    private int ageRestriction;

    @Column
    private int gameFileSizeInGB;

    @Column
    private int achievementNumber;

    @OneToMany(mappedBy = "game")
    private Set<DLC> dlcs;
}
