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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
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

    @ManyToMany
    @JoinTable(
            name = "GenreGame",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "PlatformGame",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private Set<Platform> platforms;
}
