package packagetracking.server.pkg;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import packagetracking.server.courier.Courier;


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

    private PackageStatus status;

    @ManyToOne
    private Courier courier;
}
