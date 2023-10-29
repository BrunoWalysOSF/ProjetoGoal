package digital.osf.hackazillians.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import digital.osf.hackazillians.entities.LasteAvaliation;
import digital.osf.hackazillians.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assessment")
public class Assessment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "last_avaliation")
    @JsonBackReference
    private LasteAvaliation lastAvaliation;

    @Column(name = "dt_next_Assessment")
    private LocalDate nextAssessmentDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

//    @OneToMany(mappedBy = "linkedReview", fetch = FetchType.LAZY)
//    private List<Goal> goal;
}
