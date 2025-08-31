package com.company;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Address {

    private String street;
    private String city;
    private String country;

    public Address(Address address) {
        this(address.getStreet(), address.getCity(), address.getCountry());
    }

    @Override
    public Object clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Address(this.street, this.getCity(), this.getCountry());
        }
    }

}
