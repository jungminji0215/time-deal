package com.example.timedeal.product.dto.response;

import com.example.timedeal.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Data
public class DeleteProductResponse {
    private Long id;

    private LocalDateTime deletedAt;

    private boolean isDeleted;

    public static DeleteProductResponse toDeleteResponse(Product product) {
        return DeleteProductResponse.builder()
                .id(product.getId())
                .deletedAt(product.getDeletedAt())
                .isDeleted(product.isDeleted())
                .build();
    }
}
