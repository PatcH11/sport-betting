package com.company.betting.data.mapper;

import com.company.betting.data.dto.create.ScoreCreateDto;
import com.company.betting.data.dto.get.ScoreGetDto;
import com.company.betting.data.entity.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScoreMapper {

    public ScoreGetDto toGetDto(Score entity);

    public Score fromGetDto(ScoreGetDto getDto);

    public List<ScoreGetDto> toGetDto(Iterable<Score> entities);

    @Mapping(target = "id", ignore = true)
    public Score fromCreateDto(ScoreCreateDto createDto);
}
