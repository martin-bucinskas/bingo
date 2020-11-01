package com.martinsdomain.bingo.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@Embeddable
public class Team {

    @Id
    @GeneratedValue
    private UUID id;

    private String teamName;
    private int teamPoints;
}
