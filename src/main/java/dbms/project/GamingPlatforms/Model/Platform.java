package dbms.project.GamingPlatforms.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Platform")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private Date dateEstablished;

    @ManyToMany(mappedBy = "platforms")
    private Set<Game> games;
}
