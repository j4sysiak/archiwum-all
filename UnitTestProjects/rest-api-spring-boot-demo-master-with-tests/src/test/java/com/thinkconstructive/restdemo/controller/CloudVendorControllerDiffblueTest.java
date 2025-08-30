package com.thinkconstructive.restdemo.controller;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CloudVendorController.class})
@ExtendWith(SpringExtension.class)
class CloudVendorControllerDiffblueTest {
    @Autowired
    private CloudVendorController cloudVendorController;

    @MockBean
    private CloudVendorService cloudVendorService;

    /**
     * Method under test:
     * {@link CloudVendorController#createCloudVendorDetails(CloudVendor)}
     */
    @Test
    void testCreateCloudVendorDetails() throws Exception {
        when(cloudVendorService.createCloudVendor(Mockito.<CloudVendor>any())).thenReturn("Create Cloud Vendor");

        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setVendorAddress("42 Main St");
        cloudVendor.setVendorId("42");
        cloudVendor.setVendorName("Vendor Name");
        cloudVendor.setVendorPhoneNumber("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(cloudVendor);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cloudvendor/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cloud Vendor Created Successfully"));
    }

    /**
     * Method under test:
     * {@link CloudVendorController#deleteCloudVendorDetails(String)}
     */
    @Test
    void testDeleteCloudVendorDetails() throws Exception {
        when(cloudVendorService.deleteCloudVendor(Mockito.<String>any())).thenReturn("Delete Cloud Vendor");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cloudvendor/{vendorId}", "42");
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cloud Vendor Deleted Successfully"));
    }

    /**
     * Method under test:
     * {@link CloudVendorController#deleteCloudVendorDetails(String)}
     */
    @Test
    void testDeleteCloudVendorDetails2() throws Exception {
        when(cloudVendorService.deleteCloudVendor(Mockito.<String>any())).thenReturn("Delete Cloud Vendor");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cloudvendor/{vendorId}", "42");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cloud Vendor Deleted Successfully"));
    }

    /**
     * Method under test: {@link CloudVendorController#getAllCloudVendorDetails()}
     */
    @Test
    void testGetAllCloudVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cloudvendor/");
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CloudVendorController#getAllCloudVendorDetails()}
     */
    @Test
    void testGetAllCloudVendorDetails2() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cloudvendor/");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test:
     * {@link CloudVendorController#getCloudVendorDetails(String)}
     */
    @Test
    void testGetCloudVendorDetails() throws Exception {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setVendorAddress("42 Main St");
        cloudVendor.setVendorId("42");
        cloudVendor.setVendorName("Vendor Name");
        cloudVendor.setVendorPhoneNumber("6625550144");
        when(cloudVendorService.getCloudVendor(Mockito.<String>any())).thenReturn(cloudVendor);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cloudvendor/{vendorId}", "42");
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"data\":{\"vendorId\":\"42\",\"vendorName\":\"Vendor Name\",\"vendorAddress\":\"42 Main St\",\"vendorPhoneNumber\""
                                        + ":\"6625550144\"},\"httpStatus\":\"OK\",\"message\":\"Requested Vendor Details are given here\"}"));
    }

    /**
     * Method under test:
     * {@link CloudVendorController#updateCloudVendorDetails(CloudVendor)}
     */
    @Test
    void testUpdateCloudVendorDetails() throws Exception {
        when(cloudVendorService.updateCloudVendor(Mockito.<CloudVendor>any())).thenReturn("2020-03-01");

        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setVendorAddress("42 Main St");
        cloudVendor.setVendorId("42");
        cloudVendor.setVendorName("Vendor Name");
        cloudVendor.setVendorPhoneNumber("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(cloudVendor);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/cloudvendor/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(cloudVendorController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Cloud Vendor Updated Successfully"));
    }
}
