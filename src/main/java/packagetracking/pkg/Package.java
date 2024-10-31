package packagetracking.pkg;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import packagetracking.Courier.Courier;

import java.util.Date;

@Entity
@Data
public class Package  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private Date createdOn;

    private String deliveryAddress;

    private Status status;

    @ManyToOne
    private Courier courier;
}
