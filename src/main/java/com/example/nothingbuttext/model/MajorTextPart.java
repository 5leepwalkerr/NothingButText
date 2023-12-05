package com.example.nothingbuttext.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MajorPartFromYTVideo")
public class MajorTextPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "YT_link",nullable = false)
    private String YTLink;

    @Column(name = "majorPart",nullable = false)
    private String majorPart;

}
