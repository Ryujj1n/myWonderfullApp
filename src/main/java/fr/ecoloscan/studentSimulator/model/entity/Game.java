package fr.ecoloscan.studentSimulator.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Game {
    private long id;
    private Timestamp date;
    private int score;
    private User user;
}
