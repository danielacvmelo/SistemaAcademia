package com.projeto.academia.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<CpfValido, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isEmpty()) {
            return true;
        }

        String cpfLimpo = cpf.replaceAll("\\D", "");

        if (cpfLimpo.length() != 11) {
            return false;
        }

        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 10;

            for (int i = 0; i < 9; i++) {
                soma += (cpfLimpo.charAt(i) - '0') * peso;
                peso--;
            }

            int resto = 11 - (soma % 11);
            char digito1 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                soma += (cpfLimpo.charAt(i) - '0') * peso;
                peso--;
            }

            resto = 11 - (soma % 11);
            char digito2 = (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');

            return (digito1 == cpfLimpo.charAt(9)) && (digito2 == cpfLimpo.charAt(10));

        } catch (Exception e) {
            return false;
        }
    }
}