package com.ensam.donation.mapper;

import com.ensam.donation.dao.entities.Action;
import com.ensam.donation.dto.ActionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActionMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Action fromActionDtoToAction(ActionDto actionDto) {
        return modelMapper.map(actionDto, Action.class);
    }

    public ActionDto fromActionToActionDto(Action action) {
        return modelMapper.map(action, ActionDto.class);
    }
}
