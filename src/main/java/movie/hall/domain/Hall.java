package movie.hall.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="hall")
@Data
@NoArgsConstructor
public class Hall {

    @Id
    @Column(name = "hall_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PositiveOrZero
    @Column(name = "hall_number", unique = true)
    private Integer hallNumber;

    @NotNull
    @PositiveOrZero
    private Integer numberOfRows;

    @NotNull
    @PositiveOrZero
    private Integer numberOfSeatsInRow;

}
