package com.thinkconstructive.restdemo.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.thinkconstructive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CloudVendorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CloudVendorServiceImplDiffblueTest {
    @MockBean
    private CloudVendorRepository cloudVendorRepository;

    @Autowired
    private CloudVendorServiceImpl cloudVendorServiceImpl;

    /**
     * Method under test: {@link CloudVendorServiceImpl#getCloudVendor(String)}
     */
    @Test
    void testGetCloudVendor() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setVendorAddress("42 Main St");
        cloudVendor.setVendorId("42");
        cloudVendor.setVendorName("Vendor Name");
        cloudVendor.setVendorPhoneNumber("6625550144");
        Optional<CloudVendor> ofResult = Optional.of(cloudVendor);
        when(cloudVendorRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        CloudVendor actualCloudVendor = cloudVendorServiceImpl.getCloudVendor("42");
        verify(cloudVendorRepository, atLeast(1)).findById(Mockito.<String>any());
        assertSame(cloudVendor, actualCloudVendor);
    }

    /**
     * Method under test: {@link CloudVendorServiceImpl#getCloudVendor(String)}
     */
    @Test
    void testGetCloudVendor2() {
        Optional<CloudVendor> emptyResult = Optional.empty();
        when(cloudVendorRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(CloudVendorNotFoundException.class, () -> cloudVendorServiceImpl.getCloudVendor("42"));
        verify(cloudVendorRepository).findById(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CloudVendorServiceImpl#getCloudVendor(String)}
     */
    @Test
    void testGetCloudVendor3() {
        when(cloudVendorRepository.findById(Mockito.<String>any()))
                .thenThrow(new CloudVendorNotFoundException("An error occurred"));
        assertThrows(CloudVendorNotFoundException.class, () -> cloudVendorServiceImpl.getCloudVendor("42"));
        verify(cloudVendorRepository).findById(Mockito.<String>any());
    }
}
