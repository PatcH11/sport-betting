package com.company.betting.data.mapper;

import com.company.betting.data.dto.get.MatchDontPlayDto;
import com.company.betting.data.dto.get.MatchGetDto;
import com.company.betting.data.entity.Match;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MatchMapper {

    public MatchGetDto toGetDto(Match entity);

    public Match fromGetDto(MatchGetDto getDto);

    public List<MatchGetDto> toGetDto(Iterable<Match> entities);

    @Named("dontPlay")
    MatchDontPlayDto fromMatch(Match match);

    @IterableMapping(qualifiedByName = "dontPlay")
    List<MatchDontPlayDto> toMatchDontPlayDto(Iterable<Match> entities);
}
