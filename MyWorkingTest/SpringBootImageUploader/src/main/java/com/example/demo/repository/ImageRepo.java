package com.example.demo.repository;

import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {


}
