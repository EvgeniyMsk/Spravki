package ou.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecordSpravka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String initiator;
    private String date;
    @NotEmpty
    private String duty;

    public RecordSpravka(String initiator, String date, String duty) {
        this.initiator = initiator;
        this.date = date;
        this.duty = duty;
    }
}
