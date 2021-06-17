package com.company.betting.service.impl;

import com.company.betting.data.dto.get.PictureGetDto;
import com.company.betting.data.entity.Picture;
import com.company.betting.data.mapper.PictureMapper;
import com.company.betting.data.repository.PictureRepository;
import com.company.betting.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureMapper pictureMapper;
    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository,
                              PictureMapper pictureMapper) {
        this.pictureRepository = pictureRepository;
        this.pictureMapper = pictureMapper;
    }

    @Override
    public PictureGetDto create(MultipartFile picture) throws IOException {
        String name = StringUtils.cleanPath(picture.getOriginalFilename());
        Picture pic = new Picture();
        pic.setName(name);
        pic.setType(picture.getContentType());
        pic.setData(picture.getBytes());

        return pictureMapper.toGetDto(pictureRepository.save(pic));
    }

    @Override
    public PictureGetDto getPicture(int id) {
        return pictureMapper.toGetDto(pictureRepository.findById(id).get());
    }

    @Override
    public PictureGetDto findByName(String name) {
        return pictureMapper.toGetDto(pictureRepository.findByName(name));
    }
}
