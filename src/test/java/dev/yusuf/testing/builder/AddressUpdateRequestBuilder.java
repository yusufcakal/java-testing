package dev.yusuf.testing.builder;

import dev.yusuf.testing.address.message.request.AddressUpdateRequest;

public class AddressUpdateRequestBuilder {

    private Long id;
    private Long memberId;
    private String city;
    private String county;
    private String street;

    private AddressUpdateRequestBuilder() {
    }

    public static AddressUpdateRequestBuilder anAddressUpdateRequestBuilder() {
        return new AddressUpdateRequestBuilder();
    }

    public AddressUpdateRequestBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public AddressUpdateRequestBuilder memberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public AddressUpdateRequestBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressUpdateRequestBuilder county(String county) {
        this.county = county;
        return this;
    }

    public AddressUpdateRequestBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressUpdateRequest build() {
        AddressUpdateRequest addressUpdateRequest = new AddressUpdateRequest();
        addressUpdateRequest.setId(id);
        addressUpdateRequest.setMemberId(memberId);
        addressUpdateRequest.setCity(city);
        addressUpdateRequest.setCounty(county);
        addressUpdateRequest.setStreet(street);
        return addressUpdateRequest;
    }
}
