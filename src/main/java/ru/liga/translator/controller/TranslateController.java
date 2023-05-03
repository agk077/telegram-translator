package ru.liga.translator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.translator.service.translate.impl.TranslateService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/translate")
public class TranslateController {
   private final TranslateService translateService;

    @GetMapping("/{word}")
    public String translate(@PathVariable String word) {
        return translateService.translate(word);
    }


}
