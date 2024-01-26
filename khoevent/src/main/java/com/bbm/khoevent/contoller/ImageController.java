package com.bbm.khoevent.contoller;

import com.bbm.khoevent.model.Image;
import com.bbm.khoevent.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/images")
public class ImageController {

    private  final ImageService imageService;

    @PostMapping("/{id}")
    private ResponseEntity<String> upload(@RequestParam("file")MultipartFile file, @PathVariable("id") Long id){
        return new ResponseEntity<>(imageService.upload(file,id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> download(@PathVariable("id") Long id){
        Image image = imageService.download(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadImage (@PathVariable("id") Long id){
        Image image = imageService.download(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachament; filename=\""+ image.getOriginalFileName() + "\"")
                        .body(new ByteArrayResource(image.getImage()));
    }
}
