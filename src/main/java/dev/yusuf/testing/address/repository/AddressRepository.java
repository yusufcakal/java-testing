package dev.yusuf.testing.address.repository;

import dev.yusuf.testing.address.message.model.Address;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressRepository {

    public Address update(Address address) {
        return address;
    }

    public Optional<Address> findById(Long memberId) {
        return Optional.of(new Address());
    }
}
