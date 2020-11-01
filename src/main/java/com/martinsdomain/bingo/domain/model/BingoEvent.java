package com.martinsdomain.bingo.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class BingoEvent {

    @Id
    @GeneratedValue
    private UUID id;

    private String eventName;
    private Instant startDate;
    private Instant finishDate;
    private boolean eventStarted;
}
