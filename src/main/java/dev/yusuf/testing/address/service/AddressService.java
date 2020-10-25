package dev.yusuf.testing.address.service;

import dev.yusuf.testing.address.exception.AddressUpdateException;
import dev.yusuf.testing.address.message.model.Address;
import dev.yusuf.testing.address.message.model.Notification;
import dev.yusuf.testing.address.message.request.AddressUpdateRequest;
import dev.yusuf.testing.address.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final SendNotificationService sendNotificationService;

    public AddressService(AddressRepository addressRepository, SendNotificationService sendNotificationService) {
        this.addressRepository = addressRepository;
        this.sendNotificationService = sendNotificationService;
    }

    public void update(AddressUpdateRequest addressUpdateRequest) {
        Optional<Address> addressOpt = addressRepository.findById(addressUpdateRequest.getId());
        addressOpt.map(address -> addressRepository.update(buildAddressFor(addressUpdateRequest))).orElseThrow(AddressUpdateException::new);
        Notification notification = Notification.addressUpdateSuccessNotification(addressUpdateRequest.getMemberId());
        sendNotificationService.send(notification);
    }

    private Address buildAddressFor(AddressUpdateRequest addressUpdateRequest) {
        Address address = new Address();
        address.setId(addressUpdateRequest.getId());
        address.setCity("");
        address.setCounty(addressUpdateRequest.getCounty());
        address.setStreet(addressUpdateRequest.getStreet());
        return address;
    }
}
