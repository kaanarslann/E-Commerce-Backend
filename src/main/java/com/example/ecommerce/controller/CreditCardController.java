package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.service.CreditCardService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CreditCardController {
    private final CreditCardService creditCardService;

    @GetMapping("/card")
    public List<CreditCardResponse> getCreditCards() {
        return creditCardService.getCreditCards();
    }

    @PostMapping("/card")
    public CreditCardResponse save(@Validated @RequestBody CreditCardRequest cardRequest) {
        return creditCardService.save(cardRequest);
    }

    @PutMapping("/card")
    public CreditCardResponse update(@Positive Long id, @Validated @RequestBody CreditCardRequest cardRequest) {
        return creditCardService.update(id, cardRequest);
    }

    @DeleteMapping("/card/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long id) {
        creditCardService.delete(id);
    }
}
