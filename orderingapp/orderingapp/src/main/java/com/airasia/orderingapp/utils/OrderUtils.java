package com.airasia.orderingapp.utils;

import com.airasia.orderingapp.exception.OrderException;
import com.airasia.orderingapp.model.OrderInput;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
public class OrderUtils {

    public void validateInput(OrderInput input) throws OrderException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<OrderInput>> violations = validator.validate(input);
        if (!violations.isEmpty()) {
            throw new OrderException(input.getHotelId(),400,violations.toString());
        }
    }
}
