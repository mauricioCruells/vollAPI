package med.voll.api.medic;

import med.voll.api.address.AddressDto;

public record CreateMedicDto(
        String name,
        String email,
        String description,
        Specialty specialty,
        AddressDto address) {

}
