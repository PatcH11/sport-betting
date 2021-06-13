package com.company.betting.service.impl;

import com.company.betting.data.entity.Picture;
import com.company.betting.data.repository.PictureRepository;
import com.company.betting.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    /**
     * Репозиторий для картинки.
     */
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture create(MultipartFile picture) throws IOException {
        String name = StringUtils.cleanPath(picture.getOriginalFilename());
        Picture pic = new Picture();
        pic.setName(name);
        pic.setType(picture.getContentType());
        pic.setData(picture.getBytes());

        return pictureRepository.save(pic);
    }

    @Override
    public Picture getPicture(int id) {
        return pictureRepository.findById(id).get();
    }

    @Override
    public Picture findByName(String name) {
        return pictureRepository.findByName(name);
    }
}
