package digital.osf.hackazillians.constant;


import lombok.Getter;


@Getter
public enum TypeQuestion {

    ACHIEVE("How to get the goal: "), STUDY_RECOMMENDATION_COURSES("Give me sugestions of courses about: "),
    STUDY_RECOMMENDATION_READING("Give me sugestions of reading about: "),
    FREE("I want to talk about: ");


    private String description;

    TypeQuestion(String description) {
        this.description = description;
    }
}

