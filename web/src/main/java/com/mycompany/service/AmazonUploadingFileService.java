package com.mycompany.service;

import com.mycompany.domain.hibernate.HibernateUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;

public interface AmazonUploadingFileService  {
    String uploadFile(byte[] imageBytes, Long userId) throws IOException;


}