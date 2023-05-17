package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(
  @NotBlank String street,
  @NotBlank String city,
  @NotBlank String state,
  String houseNumber,
  String extraInfo
) {}
