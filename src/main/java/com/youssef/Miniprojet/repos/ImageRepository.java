package com.youssef.Miniprojet.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.youssef.Miniprojet.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
