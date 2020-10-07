package dev.yusuf.testing.builder;

import dev.yusuf.testing.address.message.model.Address;

public class AddressBuilder {

    private Long id;
    private String city;
    private String county;
    private String street;

    private AddressBuilder() {
    }

    public static AddressBuilder anAddressBuilder() {
        return new AddressBuilder();
    }

    public AddressBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder county(String county) {
        this.county = county;
        return this;
    }

    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setId(id);
        address.setCity(city);
        address.setCounty(county);
        address.setStreet(street);
        return address;
    }
}
