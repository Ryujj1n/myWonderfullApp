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
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    @Getter(AccessLevel.NONE)
    private Long id;
    private String label;
    private String image;
    private String description;

    @ManyToOne
    private CardStatistic statistic;
}
