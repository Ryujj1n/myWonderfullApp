package fr.ecoloscan.studentSimulator.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonbTransient
    @Getter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonbTransient
    @NotNull
    // length > 8; 1 number {0:9; 1 lower case letter; 1 upper case letter; 1 special character; no whitespace
    @Pattern(regexp = ".*(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!$%^&+=])(?=\\S+$).*", message = "Le mot de passe saisi n'est pas assez sécurisé")
    @Getter(AccessLevel.NONE)
    private String password;

    @Getter(AccessLevel.PUBLIC)
    private Long score;

}
