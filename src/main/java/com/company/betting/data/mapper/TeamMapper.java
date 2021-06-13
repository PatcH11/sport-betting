package com.company.betting.data.mapper;

import com.company.betting.data.dto.get.TeamGetDto;
import com.company.betting.data.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    public TeamGetDto toGetDto(Team entity);

    public Team fromGetDto(TeamGetDto getDto);

    public List<TeamGetDto> toGetDto(Iterable<Team> entities);
}
