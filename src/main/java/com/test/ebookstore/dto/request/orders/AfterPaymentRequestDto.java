package com.test.ebookstore.dto.request.orders;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AfterPaymentRequestDto {
    
    @NotBlank
    private String state; // 결제상태
    private Integer ordersId; // 주문고유번호
    private Integer booksId; // 책고유번호
    private Integer orderItemsCount; // 수량
}
