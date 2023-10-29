package digital.osf.hackazillians.mapper;

import digital.osf.hackazillians.entities.TypeStudyRecomendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeStudyRecomendationMapper {

    TypeStudyRecomendation toEntity(TypeStudyRecomendation typeStudyRecomendation);
}
