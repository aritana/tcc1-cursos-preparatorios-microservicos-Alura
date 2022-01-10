package br.com.alura.forum.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {
    String token;
    String tipo;
}
