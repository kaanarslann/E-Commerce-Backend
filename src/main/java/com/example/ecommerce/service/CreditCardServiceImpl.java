package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.entity.CreditCard;
import com.example.ecommerce.mapper.CreditCardMapper;
import com.example.ecommerce.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public List<CreditCardResponse> getCreditCards() {
        return creditCardRepository.findAll().stream().map(creditCardMapper::toResponse).toList();
    }

    @Override
    public CreditCardResponse save(CreditCardRequest creditCardRequest) {
        CreditCard creditCard = creditCardRepository.save(creditCardMapper.toEntity(creditCardRequest));
        return creditCardMapper.toResponse(creditCard);
    }

    @Override
    public CreditCardResponse update(Long id, CreditCardRequest creditCardRequest) {
        CreditCard creditCard = creditCardMapper.toEntity(creditCardRequest);
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        if(optionalCreditCard.isPresent()) {
            return creditCardMapper.toResponse(creditCardRepository.save(creditCard));
        }
        return creditCardMapper.toResponse(creditCardRepository.save(creditCard));
    }

    @Override
    public void delete(Long id) {
        creditCardRepository.deleteById(id);
    }
}
