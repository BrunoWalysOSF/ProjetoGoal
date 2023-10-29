package digital.osf.hackazillians.service.impl;

import digital.osf.hackazillians.constant.TypeQuestion;
import digital.osf.hackazillians.constant.TypeRecomendation;
import digital.osf.hackazillians.dto.AchieveGoalDto;
import digital.osf.hackazillians.dto.GoalDto;
import digital.osf.hackazillians.dto.StudyRecomendationDto;
import digital.osf.hackazillians.dto.TypeStudyRecomendationDto;
import digital.osf.hackazillians.entities.AchieveGoal;
import digital.osf.hackazillians.entities.StudyRecomendation;
import digital.osf.hackazillians.mapper.StudyRecomendationMapper;
import digital.osf.hackazillians.repositories.AchieveGoalRepository;
import digital.osf.hackazillians.repositories.StudyRecomendationRepository;
import digital.osf.hackazillians.service.StudyRecomendationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudyRecomendationServiceImpl implements StudyRecomendationService {


    private final ChatAiStudyRecomendationService chatAiStudyRecomendationService;
    private final StudyRecomendationRepository studyRecomendationRepository;
    private final StudyRecomendationMapper studyRecomendationMapper;
    private final AchieveGoalRepository achieveGoalRepository;

    private static final int MAX_RESPONSE = 3;

    @Override
    public List<StudyRecomendationDto> findRecomendationByAchieve(AchieveGoalDto achieveGoalDto,
                                                                  TypeRecomendation typeStudyRecomendation) {
        TypeQuestion typeQuestion = TypeQuestion.STUDY_RECOMMENDATION_READING;
        if(TypeRecomendation.COURSE.equals(typeStudyRecomendation)){
            typeQuestion = TypeQuestion.STUDY_RECOMMENDATION_COURSES;
        }
        List<String> recomendations = chatAiStudyRecomendationService.askStudyRecomendationToAI(achieveGoalDto.getDescription(),
                typeQuestion);
        return recomendations.stream().map(recomendation -> StudyRecomendationDto.builder()
                .id(null)
                .description(recomendation)
                .achieveId(achieveGoalDto)
                .typeId(TypeStudyRecomendationDto.builder()
                        .id(typeStudyRecomendation.getId())
                        .type(typeStudyRecomendation.name()).build())
                .build()).limit(MAX_RESPONSE).collect(Collectors.toList());

    }

    @Override
    public List<GoalDto> saveStudyRecommendation(List<GoalDto> goals) {

           goals.forEach(goalDto -> {
                   AtomicInteger index = new AtomicInteger(0);
                   List<AchieveGoalDto> achieveGoalDtoList = new ArrayList<>();
                   goalDto.getAchieveGoal().forEach(achieveGoalDto -> {
                       if (index.get() > 0) {
                           List<StudyRecomendationDto> studyRecomendationDtos = findRecomendationByAchieve(achieveGoalDto, TypeRecomendation.READING);
                           List<StudyRecomendationDto> studyRecomendationDtosCourse = findRecomendationByAchieve(achieveGoalDto, TypeRecomendation.COURSE);
                           studyRecomendationDtos.addAll(studyRecomendationDtosCourse);
                              List<StudyRecomendation> listS = studyRecomendationDtos.stream().map(studyRecomendationDto -> {
                              StudyRecomendation sr = studyRecomendationMapper.toEntity(studyRecomendationDto);

                              sr.setAchieveId(achieveGoalRepository.findById(achieveGoalDto.getId()).get());
                              return sr;
                           }).map(studyRecomendationRepository::save).collect(Collectors.toList());
                           achieveGoalDto.setStudyRecomendation(studyRecomendationMapper.toDto(listS));
                       }
                       achieveGoalDtoList.add(achieveGoalDto);
                       index.getAndIncrement();
                   });
                   goalDto.setAchieveGoal(achieveGoalDtoList);
           });

              return goals;

    }


}
