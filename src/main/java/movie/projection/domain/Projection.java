package movie.projection.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import movie.hall.domain.Hall;
import movie.film.domain.Film;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "projection")
@Data
@NoArgsConstructor
public class Projection implements Serializable {

    @Id
    @Column(name = "movie_projection_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "projection_film")
    private Film film;

    @DateTimeFormat  //"2012-04-23T18:25:43.511Z"
    private Date projectionDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "projection_hall")
    private Hall hall;

    @PositiveOrZero
    private int ticketPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status roomStatus;

    @PositiveOrZero
    private Long numberOfReservations;

}
