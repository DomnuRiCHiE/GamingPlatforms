package dbms.project.GamingPlatforms.Model;

import jakarta.persistence.*;
import lombok.*;

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
}
