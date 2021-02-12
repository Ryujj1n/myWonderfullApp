package fr.ecoloscan.studentSimulator.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    @JsonbTransient
    @Getter(AccessLevel.NONE)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    @Getter(AccessLevel.NONE)
    private String password;
}
