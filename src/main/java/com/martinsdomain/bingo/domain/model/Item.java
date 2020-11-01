package com.martinsdomain.bingo.domain.model;

import com.martinsdomain.bingo.domain.Level;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Level itemLevel;
}
