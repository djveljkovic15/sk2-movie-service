package movie.film.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import rx.BackpressureOverflow;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
public class Film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String genre;

    private String description;

    @NotNull
    @Positive
    private Integer duration;

    @NotNull
    @ElementCollection
    private List<String> actors;

}
