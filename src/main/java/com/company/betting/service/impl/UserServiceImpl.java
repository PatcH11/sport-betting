package com.company.betting.service.impl;

import com.company.betting.data.dto.create.UserCreateDto;
import com.company.betting.data.dto.get.PictureGetDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.data.entity.User;
import com.company.betting.data.mapper.UserMapper;
import com.company.betting.data.repository.UserRepository;
import com.company.betting.service.PictureService;
import com.company.betting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PictureService pictureService,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserGetDto create(UserCreateDto user) throws IOException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        PictureGetDto picture = pictureService.getPicture(user.getPictureId());

        return userMapper.toGetDto(userRepository.save(userMapper.fromCreateDto(user)));
    }

    @Override
    public UserGetDto findByUsername(String username) {
        return userMapper.toGetDto(userRepository.findByUsername(username));
    }

    @Override
    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }
}
