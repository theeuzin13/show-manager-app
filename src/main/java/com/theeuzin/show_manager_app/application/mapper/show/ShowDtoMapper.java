package com.theeuzin.show_manager_app.application.mapper.show;

import com.theeuzin.show_manager_app.application.dto.show.ShowResponse;
import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;

public class ShowDtoMapper {

    private ShowDtoMapper() {}

    public static ShowResponse toResponse(ShowEntity show){
        return new ShowResponse(
                show.getId(),
                show.getName(),
                show.getVenue(),
                show.getPrice(),
                show.getDate(),
                show.getStatus()
        );
    }
}
