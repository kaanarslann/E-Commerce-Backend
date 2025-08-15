package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CreditCardRequest;
import com.example.ecommerce.dto.CreditCardResponse;
import com.example.ecommerce.entity.CreditCard;

public class CreditCardMapper {

    public CreditCard toEntity(CreditCardRequest creditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNo(creditCardRequest.cardNo());
        creditCard.setExpireMonth(creditCardRequest.expireMonth());
        creditCard.setExpireYear(creditCardRequest.expireYear());
        creditCard.setNameOnCard(creditCardRequest.nameOnCard());

        return creditCard;
    }

    public CreditCardResponse toResponse(CreditCard creditCard) {
        return new CreditCardResponse(creditCard.getId(), creditCard.getCardNo(), creditCard.getExpireMonth(), creditCard.getExpireYear(), creditCard.getNameOnCard(), creditCard.getUser().getId());
    }
}
