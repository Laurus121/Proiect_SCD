package packagetracking.Courier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
public class Courier {
    @Id
    private Integer id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Courier manager;
}
