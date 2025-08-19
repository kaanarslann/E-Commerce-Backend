package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.entity.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCard toEntity(CreditCardRequest creditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNo(creditCardRequest.card_no());
        creditCard.setExpireMonth(creditCardRequest.expire_month());
        creditCard.setExpireYear(creditCardRequest.expire_year());
        creditCard.setNameOnCard(creditCardRequest.name_on_card());

        return creditCard;
    }

    public CreditCardResponse toResponse(CreditCard creditCard) {
        return new CreditCardResponse(creditCard.getId(), creditCard.getCardNo(), creditCard.getExpireMonth(), creditCard.getExpireYear(), creditCard.getNameOnCard(), creditCard.getUser().getId());
    }
}
