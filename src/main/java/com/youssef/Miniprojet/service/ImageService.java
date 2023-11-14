package com.youssef.Miniprojet.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.youssef.Miniprojet.entities.Image;
public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image uplaodImageVoit(MultipartFile file,Long idVoit) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 public List<Image> getImagesParProd(Long prodId);
}
