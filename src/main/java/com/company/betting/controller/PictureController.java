package com.company.betting.controller;

import com.company.betting.data.dto.get.PictureGetDto;
import com.company.betting.service.PictureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(
        path = "api/picture"
)
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public PictureGetDto uploadPicture(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return pictureService.create(multipartFile);
    }
}
