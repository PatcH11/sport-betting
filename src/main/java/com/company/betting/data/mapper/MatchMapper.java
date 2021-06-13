package com.company.betting.data.mapper;

import com.company.betting.data.dto.get.MatchGetDto;
import com.company.betting.data.entity.Match;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    public MatchGetDto toGetDto(Match entity);

    public Match fromGetDto(MatchGetDto getDto);

    public List<MatchGetDto> toGetDto(Iterable<Match> entities);
}
