package packagetracking.Courier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Courier {
    @Id
    private Integer id;
    private String name;
    private String email;
    private Integer manager_id;
}
