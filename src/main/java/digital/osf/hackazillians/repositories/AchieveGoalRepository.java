package digital.osf.hackazillians.repositories;

import digital.osf.hackazillians.entities.AchieveGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchieveGoalRepository extends JpaRepository<AchieveGoal, Integer>{
}
