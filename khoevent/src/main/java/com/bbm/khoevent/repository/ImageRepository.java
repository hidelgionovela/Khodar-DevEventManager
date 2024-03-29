package com.bbm.khoevent.repository;

import com.bbm.khoevent.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByEventId(Long id);
}
