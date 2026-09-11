package com.theeuzin.show_manager_app.application.service.show;

import com.theeuzin.show_manager_app.application.dto.show.ShowRequest;
import com.theeuzin.show_manager_app.application.dto.show.ShowResponse;
import com.theeuzin.show_manager_app.application.mapper.show.ShowDtoMapper;
import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;
import com.theeuzin.show_manager_app.domain.exception.show.ShowNotFoundException;
import com.theeuzin.show_manager_app.domain.gateway.show.ShowGateway;

import java.util.List;
import java.util.UUID;

public class ShowService {

    private final ShowGateway showGateway;

    public ShowService(ShowGateway showGateway) {
        this.showGateway = showGateway;
    }

    public List<ShowResponse> findAll() {
        return showGateway.findAll().stream()
                .map(ShowDtoMapper::toResponse)
                .toList();
    }

    public ShowResponse findById(UUID id) {
        return ShowDtoMapper.toResponse(getShow(id));
    }

    public ShowResponse update(UUID id, ShowRequest request) {
        ShowEntity show = getShow(id);
        show.updateDetails(request.name(), request.venue(), request.price(), request.date());
        return ShowDtoMapper.toResponse(showGateway.update(show));
    }

    public void delete(UUID id) {
        getShow(id);
        showGateway.deleteById(id);
    }

    private ShowEntity getShow(UUID id) {
        return showGateway.findById(id)
                .orElseThrow(() -> new ShowNotFoundException(id));
    }
}