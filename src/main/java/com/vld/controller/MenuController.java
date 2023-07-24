package com.vld.controller;

import com.vld.controller.dto.AlcoholResponseDto;
import com.vld.service.MenuService;
import com.vld.util.MenuUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping("/menu/{barId}")
    public List<AlcoholResponseDto> alcoholList(@PathVariable Long barId) {
        return MenuUtil.AlcoholToAlcoholResponseDto(service.getBarAlcohol(barId));
    }

    @PostMapping("menu/{barId}/{alcoholId}")
    public void addAlcoholToBar(@PathVariable Long barId, @PathVariable Long alcoholId) {
        service.addAlcoholToBar(barId, alcoholId);
    }

    @DeleteMapping("menu/{barId}/{alcoholId}")
    public void deleteAlcoholFromBar(@PathVariable Long barId, @PathVariable Long alcoholId) {
        service.deleteAlcoholFromBar(barId, alcoholId);
    }
}
