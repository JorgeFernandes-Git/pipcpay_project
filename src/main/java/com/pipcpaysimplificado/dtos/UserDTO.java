package com.pipcpaysimplificado.dtos;

import com.pipcpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String password, UserType userType, String email) {
}
