package com.company.betting.data.mapper;

import com.company.betting.data.dto.create.PictureCreateDto;
import com.company.betting.data.dto.get.PictureGetDto;
import com.company.betting.data.entity.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMapper {

    public PictureGetDto toGetDto(Picture entity);

    public Picture fromGetDto(PictureGetDto getDto);

    public List<PictureGetDto> toGetDto(Iterable<Picture> entities);

    @Mapping(target = "id", ignore = true)
    public Picture fromCreateDto(PictureCreateDto createDto);
}
