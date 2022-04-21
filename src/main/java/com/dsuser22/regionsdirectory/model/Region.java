package com.dsuser22.regionsdirectory.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Region implements Serializable {
    private Long id;
    private String name;
    private String shortName;

    public Region(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

}
