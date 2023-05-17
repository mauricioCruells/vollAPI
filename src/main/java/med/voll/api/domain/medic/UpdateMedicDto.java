package med.voll.api.domain.medic;

import med.voll.api.domain.address.AddressDto;

public record UpdateMedicDto(
  String name,
  String description,
  AddressDto address
) {}
