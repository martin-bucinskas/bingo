package com.martinsdomain.bingo.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class TeamItem {

    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    private Team team;

    @OneToOne
    private Player player;

    @OneToOne
    private Item item;
}
