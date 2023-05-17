package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  private String street;
  private String city;
  private String state;
  private String houseNumber;
  private String extraInfo;

  public Address(AddressDto addressDto) {
    this.street = addressDto.street();
    this.city = addressDto.city();
    this.state = addressDto.state();
    this.houseNumber = addressDto.houseNumber();
    this.extraInfo = addressDto.extraInfo();
  }

  public Address updateAddress(AddressDto addressDto) {
    this.street = addressDto.street();
    this.city = addressDto.city();
    this.state = addressDto.state();
    this.houseNumber = addressDto.houseNumber();
    this.extraInfo = addressDto.extraInfo();

    return this;
  }
}
