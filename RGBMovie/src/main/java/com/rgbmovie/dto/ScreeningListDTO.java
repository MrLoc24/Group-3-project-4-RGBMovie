package com.rgbmovie.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ScreeningListDTO {
    private Integer pk;
    private Integer movie;
    private Integer theater;
    private Integer auditorium;
    private String date;

    private List<String> time;
    

    public ScreeningListDTO() {

    }
}
