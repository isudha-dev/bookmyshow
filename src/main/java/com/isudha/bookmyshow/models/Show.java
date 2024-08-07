package com.isudha.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show extends BaseModel {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    private Screen screen;
    private LocalDateTime startTime;

    @OneToMany(mappedBy = "show", fetch = FetchType.EAGER)
    private List<ShowSeat> showSeats = new ArrayList<>();
}

/*

Hibernate: select s1_0.id,s1_0.created_at,s1_0.modified_at,m1_0.id,m1_0.created_at,m1_0.duration,m1_0.modified_at,m1_0.name,s2_0.id,s2_0.created_at,s2_0.modified_at,s2_0.number,t1_0.id,t1_0.address,t1_0.city_id,t1_0.created_at,t1_0.modified_at,t1_0.name,s1_0.start_time,ss1_0.show_id,ss1_0.id,ss1_0.created_at,ss1_0.modified_at,s3_0.id,s3_0.col_num,s3_0.created_at,s3_0.modified_at,s3_0.row_num,s3_0.screen_id,s3_0.type,ss1_0.seat_status from shows s1_0 left join movies m1_0 on m1_0.id=s1_0.movie_id left join screens s2_0 on s2_0.id=s1_0.screen_id left join theaters t1_0 on t1_0.id=s2_0.theater_id left join showseats ss1_0 on s1_0.id=ss1_0.show_id left join seats s3_0 on s3_0.id=ss1_0.seat_id where s1_0.id=?
Hibernate: select c1_0.id,c1_0.created_at,c1_0.modified_at,c1_0.name from cities c1_0 where c1_0.id=?
Hibernate: select s1_0.theater_id,s1_1.id,s1_1.created_at,s1_1.modified_at,m1_0.id,m1_0.created_at,m1_0.duration,m1_0.modified_at,m1_0.name,s2_0.id,s2_0.created_at,s2_0.modified_at,s2_0.number,t1_0.id,t1_0.address,t1_0.city_id,t1_0.created_at,t1_0.modified_at,t1_0.name,s1_1.start_time from theaters_shows s1_0 join shows s1_1 on s1_1.id=s1_0.shows_id left join movies m1_0 on m1_0.id=s1_1.movie_id left join screens s2_0 on s2_0.id=s1_1.screen_id left join theaters t1_0 on t1_0.id=s2_0.theater_id where s1_0.theater_id=?

 */
