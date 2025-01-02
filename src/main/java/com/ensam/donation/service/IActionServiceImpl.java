package com.ensam.donation.service;

import com.ensam.donation.dao.entities.Action;
import com.ensam.donation.dao.entities.Don;
import com.ensam.donation.dao.repositories.ActionRepository;
import com.ensam.donation.dto.ActionDto;
import com.ensam.donation.dto.DonDto;
import com.ensam.donation.mapper.ActionMapper;
import com.ensam.donation.mapper.DonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IActionServiceImpl implements IActionService {

    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private DonMapper donMapper;

    @Override
    public ActionDto addAction(ActionDto actionDto) {
        Action action = actionMapper.fromActionDtoToAction(actionDto);
        return actionMapper.fromActionToActionDto(
                actionRepository.save(action)
        );
    }

    @Override
    public List<ActionDto> getActions() {
        List<Action> actions = actionRepository.findAll();
        return actions.stream().map(actionMapper::fromActionToActionDto).toList();
    }

    @Override
    public ActionDto getActionById(Integer id) {
        Action action = actionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Action not found with id: " + id));
        return actionMapper.fromActionToActionDto(action);
    }

    @Override
    public List<DonDto> getDonsOfActionById(Integer actionId) {
        Action action = actionRepository.findById(actionId)
                .orElseThrow(() -> new RuntimeException("Action not found with id: " + actionId));

        List<Don> dons = action.getDons();
        return dons.stream().map(donMapper::fromDonToDonDto).toList();
    }
}
