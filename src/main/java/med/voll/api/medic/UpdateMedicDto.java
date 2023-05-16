package med.voll.api.medic;

import med.voll.api.address.AddressDto;

public record UpdateMedicDto(String name, String description, AddressDto address) {
}
