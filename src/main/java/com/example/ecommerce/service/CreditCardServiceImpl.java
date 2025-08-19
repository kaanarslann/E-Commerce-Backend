package com.example.ecommerce.service;

import com.example.ecommerce.dto.BackendResponse;
import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.entity.CreditCard;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exceptions.CardAlreadyExistsException;
import com.example.ecommerce.exceptions.EntityNotFoundException;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.mapper.CreditCardMapper;
import com.example.ecommerce.repository.CreditCardRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        if(creditCardRepository.findByCardNo(creditCardRequest.card_no()).isPresent()) {
            throw new CardAlreadyExistsException("Credit Card already exists.");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found."));

        CreditCard creditCard = creditCardMapper.toEntity(creditCardRequest);
        creditCard.setUser(user);
        return creditCardMapper.toResponse(creditCardRepository.save(creditCard));
    }

    @Override
    public CreditCardResponse update(Long id, CreditCardRequest creditCardRequest) {
        CreditCard existingCard = creditCardRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Card not found."));
        CreditCard creditCard = creditCardMapper.toEntity(creditCardRequest);
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(id);
        if(optionalCreditCard.isPresent()) {
            creditCard.setId(id);
            creditCard.setUser(existingCard.getUser());
            return creditCardMapper.toResponse(creditCardRepository.save(creditCard));
        }
        return creditCardMapper.toResponse(creditCardRepository.save(creditCard));
    }

    @Override
    public BackendResponse delete(Long id) {
        if(!creditCardRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Card not found");
        }
        creditCardRepository.deleteById(id);
        return new BackendResponse("Record deleted successfully!");
    }
}
