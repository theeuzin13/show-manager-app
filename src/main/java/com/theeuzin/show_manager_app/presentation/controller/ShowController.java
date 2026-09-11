package com.theeuzin.show_manager_app.presentation.controller;

import com.theeuzin.show_manager_app.application.dto.show.ShowRequest;
import com.theeuzin.show_manager_app.application.dto.show.ShowResponse;
import com.theeuzin.show_manager_app.application.service.show.ShowService;
import com.theeuzin.show_manager_app.application.usecase.show.CreateShowUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final CreateShowUseCase createShowUseCase;
    private final ShowService showService;

    public ShowController(CreateShowUseCase createShowUseCase, ShowService showService) {
        this.createShowUseCase = createShowUseCase;
        this.showService = showService;
    }

    @PostMapping
    public ResponseEntity<ShowResponse> create(@Valid @RequestBody ShowRequest request) {
        ShowResponse response = createShowUseCase.execute(request);
        return ResponseEntity
                .created(URI.create("/shows/" + response.id()))
                .body(response);
    }

    @GetMapping
    public List<ShowResponse> findAll() {
        return showService.findAll();
    }

    @GetMapping("/{id}")
    public ShowResponse findById(@PathVariable UUID id) {
        return showService.findById(id);
    }

    @PutMapping("/{id}")
    public ShowResponse update(@PathVariable UUID id, @Valid @RequestBody ShowRequest request) {
        return showService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        showService.delete(id);
        return ResponseEntity.noContent().build();
    }
}