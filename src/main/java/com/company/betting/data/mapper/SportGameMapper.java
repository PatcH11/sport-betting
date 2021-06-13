package com.company.betting.data.mapper;

import com.company.betting.data.dto.get.SportGameGetDto;
import com.company.betting.data.entity.SportGame;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SportGameMapper {

    public SportGameGetDto toGetDto(SportGame entity);

    public SportGame fromGetDto(SportGameGetDto getDto);

    public List<SportGameGetDto> toGetDto(Iterable<SportGame> entities);
}
