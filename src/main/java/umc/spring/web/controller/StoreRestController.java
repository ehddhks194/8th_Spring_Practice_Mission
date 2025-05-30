package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.missionService.MissionService;
import umc.spring.service.storeService.StoreQueryService;
import umc.spring.service.storeService.StoreService;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.mission.MissionResponseDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;
import umc.spring.web.dto.store.StoreRequestDTO;
import umc.spring.web.dto.store.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreService storeService;
    private final StoreQueryService storeQueryService;
    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDto> create(@RequestBody @Valid StoreRequestDTO.CreateStoreDto request) {
        Store newStore = storeService.create(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDto(newStore));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.PreviewReviewListResultDto> getReviewList(@ExistStores @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.previewReviewListResultDto(reviewList));

    }
    @GetMapping("/{storesId}/missions")
    @Operation(summary = "특정 가게 미션 조회")
    public ApiResponse<MissionResponseDTO.MissionPreviewListResultDto> getMissionList(@RequestParam(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionService.getMissionList(storeId, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreviewListResultDto(missionList));

    }
}