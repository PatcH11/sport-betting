package com.company.betting.data.mapper;

import com.company.betting.data.dto.create.UserCreateDto;
import com.company.betting.data.dto.get.UserGetDto;
import com.company.betting.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public UserGetDto toGetDto(User entity);

    public User fromGetDto(UserGetDto getDto);

    public List<UserGetDto> toGetDto(Iterable<User> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "picture.id", source = "pictureId")
    public User fromCreateDto(UserCreateDto createDto);
}
