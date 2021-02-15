package fr.ecoloscan.studentSimulator.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class CardStatistic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    @Getter(AccessLevel.NONE)
    private String id;

    private Long averageScore;
    private Long alcoolScore;
    private Long tiredScore;
    private Long happinessScore;
    private Long moneyScore;

}
