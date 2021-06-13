package com.company.betting.data.mapper;

import com.company.betting.data.dto.create.BetCreateDto;
import com.company.betting.data.dto.get.BetGetDto;
import com.company.betting.data.entity.Bet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BetMapper {

    public BetGetDto toGetDto(Bet entity);

    public Bet fromGetDto(BetGetDto getDto);

    public List<BetGetDto> toGetDto(Iterable<Bet> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "match.id", source = "matchId")
    @Mapping(target = "winner.id", source = "teamWinnerId")
    public Bet fromCreateDto(BetCreateDto createDto);
}
