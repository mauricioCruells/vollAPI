package med.voll.api.medic;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "medics")
@Entity(name = "Medic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

    public Medic(CreateMedicDto createMedicDto) {
        this.name = createMedicDto.name();
        this.email = createMedicDto.email();
        this.description = createMedicDto.description();
        this.specialty = createMedicDto.specialty();
        this.address = new Address(createMedicDto.address());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String description;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded()
    Address address;

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return super.toString();
        }
    }
}
