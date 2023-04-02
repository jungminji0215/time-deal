package com.example.timedeal.timedeal.controller;


import com.example.timedeal.timedeal.dto.request.CreateTimeDealRequest;
import com.example.timedeal.timedeal.dto.request.UpdateTimeDealRequest;
import com.example.timedeal.timedeal.dto.response.CreateTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.FinishTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.GetTimeDealResponse;
import com.example.timedeal.timedeal.dto.response.UpdateTimeDealResponse;
import com.example.timedeal.timedeal.service.TimeDealService;
import com.example.timedeal.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-deal")
@RequiredArgsConstructor
public class TimeDealController {
    private final TimeDealService timeDealService;

    @GetMapping
    public ApiResponse<List<GetTimeDealResponse>> list(){
        return ApiResponse.success(timeDealService.list());
    }

    @GetMapping("/{timeDealId}")
    public ApiResponse<GetTimeDealResponse> findOne(
            @PathVariable Long timeDealId
    ) {
        return ApiResponse.success(timeDealService.findOne(timeDealId));
    }

    @PostMapping
    public ApiResponse<CreateTimeDealResponse> create(
            @RequestBody CreateTimeDealRequest request
    ){
        return ApiResponse.success(timeDealService.create(request));
    }

    @PutMapping("/{timeDealId}")
    public ApiResponse<UpdateTimeDealResponse> update(
            @RequestBody UpdateTimeDealRequest request,
            @PathVariable Long timeDealId
    ){
        return ApiResponse.success(timeDealService.update(timeDealId, request));
    }

    @PutMapping("/{timeDealId}/finish")
    public ApiResponse<FinishTimeDealResponse> finish(
            @PathVariable Long timeDealId
    ){
        return ApiResponse.success(timeDealService.finish(timeDealId));
    }
}