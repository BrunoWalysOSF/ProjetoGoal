package digital.osf.hackazillians.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @NonNull
    @Column(name = "user_id")
    private int userId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "expired_date", nullable = false)
    private LocalDate expiredDate;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private int progress;

    @Column(name = "linked_review")
    private Boolean linkedReview;

    @ManyToOne
    @JoinColumn(name = "priority")
    @JsonBackReference
    private Priority priority;

    @JsonIgnore
    @OneToMany(mappedBy = "goalId", fetch = FetchType.LAZY)
    private List<AchieveGoal> achieveGoal;
}