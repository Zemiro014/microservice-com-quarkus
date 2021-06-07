package com.github.jeronimo.ifood.cadastro.infra;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// A class que valida as validações dos objetos DTO
public class ValidDTOValidator implements ConstraintValidator<ValidDTO, DTO> {

    @Override
    public void initialize(ValidDTO constraintAnnotation) {
    }

    @Override
    public boolean isValid(DTO dto, ConstraintValidatorContext constraintValidatorContext) {
        return dto.isValid(constraintValidatorContext);
    }
}
