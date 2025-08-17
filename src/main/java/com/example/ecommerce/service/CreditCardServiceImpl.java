package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.entity.CreditCard;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exceptions.CardAlreadyExistsException;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.mapper.CreditCardMapper;
import com.example.ecommerce.repository.CreditCardRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @Override
    public List<CreditCardResponse> getCreditCards() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found."));


        return creditCardRepository.findByUserId(user.getId()).stream().map(creditCardMapper::toResponse).toList();
    }

    @Override
    public CreditCardResponse save(CreditCardRequest creditCardRequest) {
        if(creditCardRepository.findByCardNo(creditCardRequest.cardNo()).isPresent()) {
            throw new CardAlreadyExistsException("Credit Card already exists.");
        }

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
