package com.test.ebookstore.dto.request.orders;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdersRequestDto {
    
    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String ordersDate; // 주문날짜
    private Integer totalPrice; // 총금액
    @NotBlank
    private String state; // 상태
    @NotBlank
    private String userId; // 유저Id
}
