package dbms.project.GamingPlatforms.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DLC")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DLC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Game game;
}
