package digital.osf.hackazillians.repositories;

import digital.osf.hackazillians.entities.TypeStudyRecomendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeStudyRecomendationRepository extends JpaRepository<TypeStudyRecomendation, Integer> {
}
