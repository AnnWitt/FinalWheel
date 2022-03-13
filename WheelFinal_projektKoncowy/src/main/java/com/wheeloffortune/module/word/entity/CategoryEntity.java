package com.wheeloffortune.module.word.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    private Long id;
    private String name;

}
