package dev.yusuf.testing.address;

import dev.yusuf.testing.address.message.model.Address;
import dev.yusuf.testing.address.message.model.Notification;
import dev.yusuf.testing.address.message.request.AddressUpdateRequest;
import dev.yusuf.testing.address.repository.AddressRepository;
import dev.yusuf.testing.address.service.AddressService;
import dev.yusuf.testing.address.service.SendNotificationService;
import dev.yusuf.testing.builder.AddressBuilder;
import dev.yusuf.testing.builder.AddressUpdateRequestBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private SendNotificationService sendNotificationService;

    @Captor
    private ArgumentCaptor<Notification> notificationArgumentCaptor;

    private AddressService addressService;

    @Before
    public void setUp() {
        addressService = new AddressService(addressRepository, sendNotificationService);
    }

    @Test
    public void shouldUpdateAddressAndSendNotification() {
        Address oldAddress = AddressBuilder.anAddressBuilder()
                .id(1L)
                .city("New York")
                .county("Albany")
                .street("Hill")
                .build();

        Address newAddress = AddressBuilder.anAddressBuilder()
                .id(1L)
                .city("California")
                .county("Alpine")
                .street("Chambers")
                .build();

        AddressUpdateRequest addressUpdateRequest = AddressUpdateRequestBuilder.anAddressUpdateRequestBuilder()
                .id(1L)
                .memberId(2L)
                .city("California")
                .county("Alpine")
                .street("Chambers")
                .build();

        when(addressRepository.findById(1L)).thenReturn(Optional.of(oldAddress));
        when(addressRepository.update(newAddress)).thenReturn(newAddress);

        addressService.update(addressUpdateRequest);

        verify(addressRepository).findById(1L);
        verify(addressRepository).update(newAddress);
        verify(sendNotificationService).send(notificationArgumentCaptor.capture());

        Notification notification = notificationArgumentCaptor.getValue();

        assertThat(notification.getMemberId(), equalTo(2L));
        assertThat(notification.getMessage(), equalTo("Your address has been updated"));
    }
}
