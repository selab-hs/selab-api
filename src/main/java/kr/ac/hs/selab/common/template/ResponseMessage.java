package kr.ac.hs.selab.common.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage implements Serializable {
    /**
     * Health CHECK
     */
    HEALTH_GOOD("R-H-0001", "서버 상태가 양호합니다."),

    /**
     * MEMBER SUCCESS RESPONSE MESSAGE
     **/
    MEMBER_INSERT_SUCCESS("R-M-0001", "회원 가입을 완료했습니다."),

    /**
     * AUTH SUCCESS RESPONSE MESSAGE
     **/
    AUTH_LOGIN_SUCCESS("R-A-0001", "로그인을 성공했습니다."),

    /**
     * BOARD SUCCESS RESPONSE MESSAGE
     **/
    BOARD_CREATE_SUCCESS("R-B-0001", "게시판 생성을 완료했습니다."),
    BOARD_FIND_SUCCESS("R-B-0002", "게시판을 정상적으로 찾았습니다."),
    BOARD_UPDATE_SUCCESS("R-B-0003", "게시판을 정상적으로 수정했습니다."),
    BOARD_DELETE_SUCCESS("R-B-0004", "게시판을 정상적으로 삭제 했습니다."),

    /**
     * POST SUCCESS RESPONSE MESSAGE
     */
    POST_CREATE_SUCCESS("R-P-0001", "게시글 생성을 완료했습니다."),
    POST_FIND_SUCCESS("R-P-0002", "게시글을 정상적으로 찾았습니다."),
    POST_UPDATE_SUCCESS("R-P-0003", "게시글을 정상적으로 수정했습니다."),
    POST_DELETE_SUCCESS("R-P-0004", "게시글을 정상적으로 삭제 했습니다."),

    /**
     * COMMENT SUCCESS RESPONSE MESSAGE
     */
    COMMENT_CREATE_SUCCESS("R-C-0001", "댓글 생성을 완료했습니다."),
    COMMENT_FIND_SUCCESS("R-C-0002", "댓글을 정상적으로 찾았습니다."),
    COMMENT_UPDATE_SUCCESS("R-C-0003", "댓글을 정상적으로 수정했습니다."),
    COMMENT_DELETE_SUCCESS("R-C-0004", "댓글을 정상적으로 삭제했습니다."),

    /**
     * COMMENT LIKE SUCCESS RESPONSE MESSAGE
     */
    COMMENT_LIKE_CREATE_SUCCESS("R-L-0001", "댓글 좋아요 성공했습니다."),
    COMMENT_LIKE_FIND_SUCCESS("R-L-0001", "댓글 좋아요 찾았습니다."),
    COMMENT_LIKE_DELETE_SUCCESS("R-L-0001", "댓글 좋아요 해제했습니다."),

    ;

    private final String code;
    private final String detail;
}