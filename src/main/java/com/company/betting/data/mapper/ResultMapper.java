package com.company.betting.data.mapper;

import com.company.betting.data.dto.create.ResultCreateDto;
import com.company.betting.data.dto.get.ResultGetDto;
import com.company.betting.data.entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResultMapper {

    public ResultGetDto toGetDto(Result entity);

    public Result fromGetDto(ResultGetDto getDto);

    public List<ResultGetDto> toGetDto(Iterable<Result> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "match.id", source = "matchId")
    @Mapping(target = "score.id", source = "scoreId")
    public Result fromCreateDto(ResultCreateDto createDto);
}
