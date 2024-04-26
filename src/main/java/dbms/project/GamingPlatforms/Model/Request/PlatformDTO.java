package dbms.project.GamingPlatforms.Model.Request;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatformDTO {
    private String name;

    private Date dateEstablished;
}
