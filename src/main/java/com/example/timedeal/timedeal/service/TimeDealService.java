package com.example.timedeal.timedeal.service;

import com.example.timedeal.timedeal.dto.request.CreateTimeDealRequest;
import com.example.timedeal.timedeal.dto.request.UpdateTimeDealRequest;
import com.example.timedeal.timedeal.dto.response.CreateTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.FinishTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.GetTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.UpdateTimeDealResponse;

import java.util.List;

public interface TimeDealService {
    List<GetTimeDealResponse> list();

    GetTimeDealResponse findOne(Long timeDealId);

    CreateTimeDealResponse create(CreateTimeDealRequest request);

    UpdateTimeDealResponse update(Long timeDealId, UpdateTimeDealRequest request);

    FinishTimeDealResponse finish(Long timeDealId);

}
