package med.voll.api.domain.medic;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voll.api.domain.address.Address;

@Table(name = "medics")
@Entity(name = "Medic")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String email;

  private String description;

  private Boolean active;

  @Enumerated(EnumType.STRING)
  private Specialty specialty;

  @Embedded
  Address address;

  public Medic(CreateMedicDto createMedicDto) {
    this.name = createMedicDto.name();
    this.email = createMedicDto.email();
    this.description = createMedicDto.description();
    this.specialty = createMedicDto.specialty();
    this.address = new Address(createMedicDto.address());
  }

  public Medic updateMedic(UpdateMedicDto updateMedicDto) {
    if (updateMedicDto.name() != null) {
      this.name = updateMedicDto.name();
    }

    if (updateMedicDto.description() != null) {
      this.description = updateMedicDto.description();
    }

    if (updateMedicDto.address() != null) {
      this.address = address.updateAddress(updateMedicDto.address());
    }

    return this;
  }

  public void deactivate(@Valid DeactivateMedicDto deactivateMedicDto) {
    if (deactivateMedicDto.active() != null) {
      this.active = deactivateMedicDto.active();
    }
  }
}
