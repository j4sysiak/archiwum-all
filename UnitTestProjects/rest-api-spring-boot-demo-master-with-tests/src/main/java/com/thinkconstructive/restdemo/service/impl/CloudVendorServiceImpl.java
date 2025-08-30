package com.thinkconstructive.restdemo.service.impl;

import com.thinkconstructive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        this.cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        // More Business Logic
        this.cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // More Business Logic
        this.cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        // More Business Logic
        if(this.cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
        return this.cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        // More Business Logic
        return this.cloudVendorRepository.findAll();
    }

    @Override
    public List<CloudVendor> getByVendorName(String vendorName)
    {
        return this.cloudVendorRepository.findByVendorName(vendorName);
    }
}
