package kr.ac.hs.selab.member.presentation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import kr.ac.hs.selab.common.template.ResponseTemplate;
import kr.ac.hs.selab.common.template.SwaggerNoteKt;
import kr.ac.hs.selab.member.dto.request.MemberCreateRequest;
import kr.ac.hs.selab.member.dto.response.MemberCreateResponse;

@Api(tags = "Member REST API")
public interface MemberSdk {

    @ApiOperation(value = "회원가입", notes = SwaggerNoteKt.MEMBER_INSERT)
    @ApiResponses(
            @ApiResponse(code = 201, message = "회원가입 성공")
    )
    ResponseTemplate<MemberCreateResponse> insert(
            @Parameter(description = "회원정보") MemberCreateRequest request);
}