package movie.cinema.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="cinema")
@Data
@NoArgsConstructor
public class Cinema {

    @Id
    @Column(name = "cinema_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PositiveOrZero
    @Column(name = "cinema_number", unique = true)
    private Integer cinemaNumber;

    @NotNull
    @PositiveOrZero
    private Integer numberOfRows;

    @NotNull
    @PositiveOrZero
    private Integer numberOfSeatsInRow;

}
