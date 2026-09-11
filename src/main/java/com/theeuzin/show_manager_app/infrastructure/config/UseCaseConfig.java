package com.theeuzin.show_manager_app.infrastructure.config;

import com.theeuzin.show_manager_app.application.service.show.ShowService;
import com.theeuzin.show_manager_app.application.usecase.show.CreateShowUseCase;
import com.theeuzin.show_manager_app.domain.gateway.show.ShowGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateShowUseCase createShowUseCase(ShowGateway showGateway) {
        return new CreateShowUseCase(showGateway);
    }

    @Bean
    public ShowService showService(ShowGateway showGateway) {
        return new ShowService(showGateway);
    }
}