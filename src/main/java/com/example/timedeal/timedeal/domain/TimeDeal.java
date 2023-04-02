package com.example.timedeal.timedeal.domain;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.timedeal.dto.request.CreateTimeDealRequest;
import com.example.timedeal.timedeal.dto.request.UpdateTimeDealRequest;
import com.example.timedeal.utils.exception.ErrorCode;
import com.example.timedeal.utils.exception.TimeDealException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class TimeDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_deal_id")
    private Long id;

    private String name;

    private int stock;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;

    private int discount;

    @ColumnDefault("false")
    private boolean isFinished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public void addProduct(Product product) {
        this.product = product;
    }

    public static TimeDeal of(
            CreateTimeDealRequest request
    ){
        return TimeDeal.builder()
                .name(request.getName())
                .stock(request.getStock())
                .startedAt(request.getStartedAt())
                .finishedAt(request.getFinishedAt())
                .discount(request.getDiscount())
                .build();
    }

    public void update(UpdateTimeDealRequest request){
        this.name = request.getName();
        this.stock = request.getStock();
        this.startedAt = request.getStartedAt();
        this.finishedAt = request.getFinishedAt();
        this.discount = request.getDiscount();
    }

    public void finish(){
        this.isFinished = true;
    }

    public void checkTime() {
        if(finishedAt.isBefore(LocalDateTime.now())){
            throw new  TimeDealException(ErrorCode.AFTER_TIME_DEAL, "종료일 : " + finishedAt);
        }

        if(startedAt.isAfter(LocalDateTime.now())){
            throw new  TimeDealException(ErrorCode.BEFORE_TIME_DEAL, "시작일 : " + startedAt);
        }
    }

    public void decreaseStock(int cnt){
        if(this.stock <= 0){
            throw new  TimeDealException(ErrorCode.SOLD_OUT, "품절");
        }

        this.stock -= cnt;
    }
}
