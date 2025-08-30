package com.thinkconstructive.restdemo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thinkconstructive.restdemo.model.CloudVendor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration(classes = {CloudVendorRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.thinkconstructive.restdemo.model"})
@DataJpaTest
class CloudVendorRepositoryDiffblueTest {
    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    /**
     * Method under test: {@link CloudVendorRepository#findByVendorName(String)}
     */
    @Test
    void testFindByVendorName() {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setVendorAddress("42 Main St");
        cloudVendor.setVendorId("42");
        cloudVendor.setVendorName("Vendor Name");
        cloudVendor.setVendorPhoneNumber("6625550144");

        CloudVendor cloudVendor2 = new CloudVendor();
        cloudVendor2.setVendorAddress("17 High St");
        cloudVendor2.setVendorId("Vendor Id");
        cloudVendor2.setVendorName("42");
        cloudVendor2.setVendorPhoneNumber("8605550118");
        cloudVendorRepository.save(cloudVendor);
        cloudVendorRepository.save(cloudVendor2);

        assertEquals(1, cloudVendorRepository.findByVendorName("Vendor Name").size());

        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Vendor Name");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
    }
}
