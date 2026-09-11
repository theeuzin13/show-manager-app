package com.theeuzin.show_manager_app.application.usecase.show;

import com.theeuzin.show_manager_app.application.dto.show.ShowRequest;
import com.theeuzin.show_manager_app.application.dto.show.ShowResponse;
import com.theeuzin.show_manager_app.application.mapper.show.ShowDtoMapper;
import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;
import com.theeuzin.show_manager_app.domain.gateway.show.ShowGateway;

public class CreateShowUseCase {

    private final ShowGateway showGateway;

    public CreateShowUseCase(ShowGateway showGateway){
        this.showGateway = showGateway;
    }

    public ShowResponse execute(ShowRequest request){
        ShowEntity show = ShowEntity.create(request.name(), request.venue(), request.price(), request.date());
        ShowEntity saved = showGateway.save(show);
        return ShowDtoMapper.toResponse(saved);
    }
}
