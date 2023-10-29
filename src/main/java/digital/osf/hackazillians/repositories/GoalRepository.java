package digital.osf.hackazillians.repositories;

import digital.osf.hackazillians.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer>{

    List<Goal> findByUserId(Integer id);
}
