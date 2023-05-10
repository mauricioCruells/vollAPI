package med.voll.api.address;

public record AddressDto(
                String street,
                String city,
                String state,
                String houseNumber,
                String extraInfo) {
}
