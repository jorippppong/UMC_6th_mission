package com.forUMC.global.apiPayLoad.code.status;

import com.forUMC.global.apiPayLoad.code.BaseErrorCode;
import com.forUMC.global.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // MEMBER
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // FOOD_CATEGORY
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOOD_CATEGORY4001", "알맞은 음식 카테고리가 없습니다."),

    // RESTAURANT_CATEGORY
    RESTAURANT_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESTAURANT_CATEGORY4001", "알맞은 식당 카테고리가 없습니다."),

    // RESTAURANT
    RESTAURANT_NOT_FOUND(HttpStatus.BAD_REQUEST, "RESTAURANT4001", "식당이 없습니다."),

    // MISSION
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST, "MISSION4001", "미션이 없습니다."),

    CHALLENGE_MISSION_EXISTS(HttpStatus.BAD_REQUEST, "CHALLENGE_MISSION4001", "진행 중이거나 진행이 완료된 미션입니다."),

    PAGE_NUMBER_UNDER_ONE(HttpStatus.BAD_REQUEST, "PAGE_NUMBER4001", "페이지 번호가 1 이상이어야 합니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");

    // ~~~ 관련 응답 ....

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
