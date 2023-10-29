package digital.osf.hackazillians.repositories;

import digital.osf.hackazillians.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

    Assessment findByUser_Id(Integer userId);
}
