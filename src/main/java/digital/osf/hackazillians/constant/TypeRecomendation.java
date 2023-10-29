package digital.osf.hackazillians.constant;

import lombok.Getter;

@Getter
public enum TypeRecomendation {

    COURSE(1),READING(2);

    private Integer id;

    TypeRecomendation(Integer id) {
        this.id = id;
    }
}
