package digital.osf.hackazillians.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "last_avaliation")
public class LasteAvaliation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nota")
    private String nota;

//    @OneToMany(mappedBy = "lastAvaliation", fetch = FetchType.LAZY)
//    private List<Assessment> assessment;

}
