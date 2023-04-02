package com.example.timedeal.timedeal.service.impl;

import com.example.timedeal.product.domain.Product;
import com.example.timedeal.product.domain.ProductRepository;
import com.example.timedeal.timedeal.domain.TimeDeal;
import com.example.timedeal.timedeal.domain.TimeDealRepository;
import com.example.timedeal.timedeal.dto.request.CreateTimeDealRequest;
import com.example.timedeal.timedeal.dto.request.UpdateTimeDealRequest;
import com.example.timedeal.timedeal.dto.response.CreateTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.FinishTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.GetTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.UpdateTimeDealResponse;
import com.example.timedeal.timedeal.service.TimeDealService;
import com.example.timedeal.utils.exception.ErrorCode;
import com.example.timedeal.utils.exception.TimeDealException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TimeDealServiceImpl implements TimeDealService {
    private final TimeDealRepository timeDealRepository;

    private final ProductRepository productRepository;

//    // TODO 페이징
    @Override
    @Transactional(readOnly = true)
    public List<GetTimeDealResponse> list() {
        List<TimeDeal> findTimeDeal = timeDealRepository.findAll();
        List<GetTimeDealResponse> result = findTimeDeal.stream()
                .map(GetTimeDealResponse::toGetResponse)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public GetTimeDealResponse findOne(Long timeDealId) {
        TimeDeal timeDeal = timeDealRepository.findById(timeDealId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.TIME_DEAL_NOT_FOUND, "타임딜 아이디 : " + timeDealId));

        return GetTimeDealResponse.toGetResponse(timeDeal);
    }

    @Override
    @Transactional
    public CreateTimeDealResponse create(CreateTimeDealRequest request) {
        TimeDeal timeDeal = TimeDeal.of(request);

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new TimeDealException(ErrorCode.PRODUCT_NOT_FOUND, "상품 아이디 : " + request.getProductId()));
        product.addTimeDeal(timeDeal);

        return CreateTimeDealResponse.toCreateResponse(timeDealRepository.save(timeDeal));
    }

    @Override
    @Transactional
    public UpdateTimeDealResponse update(Long timeDealId, UpdateTimeDealRequest request) {
        TimeDeal timeDeal = timeDealRepository.findById(timeDealId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.TIME_DEAL_NOT_FOUND, "타임딜 아이디 : " + timeDealId));
        timeDeal.update(request);

        return UpdateTimeDealResponse.toUpdateResponse(timeDeal);
    }

    @Override
    @Transactional
    public FinishTimeDealResponse finish(Long timeDealId) {
        TimeDeal timeDeal = timeDealRepository.findById(timeDealId)
                .orElseThrow(()-> new TimeDealException(ErrorCode.TIME_DEAL_NOT_FOUND, "타임딜 아이디 : " + timeDealId));
        timeDeal.finish();

        return FinishTimeDealResponse.toFinishResponse(timeDeal);
    }
}
