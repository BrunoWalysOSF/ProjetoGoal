package digital.osf.hackazillians.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "achieve_goal")
public class AchieveGoal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    @JsonBackReference
    private Goal goalId;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private int progress;

    
    @OneToMany(mappedBy = "achieveId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudyRecomendation> studyRecomendation;

}