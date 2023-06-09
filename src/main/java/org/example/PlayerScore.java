package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class PlayerScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "score")
    private int score;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "registered_at")
    private ZonedDateTime registeredAt;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public ZonedDateTime getRegisteredAt() {
        return registeredAt;
    }
}
