package com.martinsdomain.bingo.domain.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Player {

    @Id
    private String id;
    private String username;
    private String discriminator;

    private int playerPoints;

    @Embedded
    private Team team;
}
