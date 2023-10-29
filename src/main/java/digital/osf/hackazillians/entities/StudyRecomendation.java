package digital.osf.hackazillians.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyRecomendation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne( optional=true, cascade=CascadeType.ALL)
    @JoinColumn(name="achieve_id")
    @JsonBackReference
    private AchieveGoal achieveId;

    @ManyToOne
    @JoinColumn(name="type_id")
    @JsonBackReference
    private TypeStudyRecomendation typeId;

    @Column
    private String description;
}
