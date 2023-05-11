package med.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDto;

public record CreatePatientDto(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String description,
        @NotNull @Valid AddressDto address) {
}
