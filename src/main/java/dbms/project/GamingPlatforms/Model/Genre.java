package dbms.project.GamingPlatforms.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "Genre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genre {
    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Game> games;
}
