package med.voll.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDto;

public record CreateMedicDto(
        @NotBlank String name,

        @NotBlank @Email String email,

        @NotBlank String description,

        @NotNull Specialty specialty,

        @NotNull @Valid AddressDto address) {

}
