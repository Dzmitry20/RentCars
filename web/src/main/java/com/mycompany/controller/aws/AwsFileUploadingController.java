package com.mycompany.controller.aws;


import com.mycompany.domain.hibernate.HibernateUser;
import com.mycompany.domain.hibernate.UserPhoto;
import com.mycompany.repository.springdata.PhotoRepositorySpringData;
import com.mycompany.repository.springdata.UserRepositorySpringData;
import com.mycompany.service.AmazonUploadingFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/aws/upload")
@RequiredArgsConstructor
public class AwsFileUploadingController {



    private final AmazonUploadingFileService service;
    private final UserRepositorySpringData userRepository;
    private final PhotoRepositorySpringData photoRepository;

    @PostMapping("/user/{userId}")
    public ResponseEntity<Map<Object, Object>> uploadPhoto(@PathVariable Long userId,
                                                           MultipartFile photo) throws Exception {

        Optional<HibernateUser> userOptional = userRepository.findById(userId);


        if (userOptional.isPresent()) {
            String userPhotoLink = service.uploadFile(photo.getBytes(), userId);

//            userRepository.createRow(userPhotoLink,userId);
//            HibernateUser hibernateUser = userOptional.get();
//            Set<UserPhoto> photos = hibernateUser.getPhotos();
//            photos.add(new UserPhoto(userPhotoLink));
//            hibernateUser.setPhotos(photos);
//           userRepository.createRow(userPhotoLink,userId);
//            userRepository.saveUser(userPhotoLink,userId);
//            HibernateUser user2 = userRepository.findByIdHQLVersion(userId);
            HibernateUser hibernateUser = userOptional.get();
            hibernateUser.setLinkPhoto(userPhotoLink);
            userRepository.save(hibernateUser);



            return new ResponseEntity<>(Collections.singletonMap("userPhotoLink", userPhotoLink), HttpStatus.CREATED);
        } else {
            throw new RuntimeException("User not found!");
        }
    }
}
