package kr.ac.hs.selab.post.converter;

import kr.ac.hs.selab.board.converter.BoardConverter;
import kr.ac.hs.selab.board.domain.Board;
import kr.ac.hs.selab.board.dto.response.BoardResponse;
import kr.ac.hs.selab.member.domain.Member;
import kr.ac.hs.selab.member.dto.response.MemberCreateResponse;
import kr.ac.hs.selab.post.domain.Post;
import kr.ac.hs.selab.post.dto.PostCreateDto;
import kr.ac.hs.selab.post.dto.PostUpdateDto;
import kr.ac.hs.selab.post.dto.request.PostRequest;
import kr.ac.hs.selab.post.dto.response.PostResponse;
import kr.ac.hs.selab.post.dto.response.PostsResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class PostConverter {
    /**
     * to entity
     */
    public Post toPost(PostCreateDto dto, Member member, Board board) {
        return Post.builder()
                .member(member)
                .board(board)
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    /**
     * to Response
     */
    public PostResponse toPostResponse(Post post) {
        MemberCreateResponse memberCreateResponse = new MemberCreateResponse(post.getMember().getEmail());
        BoardResponse boardResponse = BoardConverter.toBoardResponse(post.getBoard());

        return PostResponse.builder()
                .member(memberCreateResponse)
                .board(boardResponse)
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .build();
    }

    public PostsResponse toPostsResponse(List<Post> posts) {
        List<PostResponse> postResponses = posts.stream()
                .map(PostConverter::toPostResponse)
                .collect(Collectors.toList());
        return PostsResponse.of(postResponses);
    }

    /**
     * to dto
     */
    public static PostCreateDto toPostCreateDto(PostRequest request, Long boardId, String memberEmail) {
        return PostCreateDto.builder()
                .memberEmail(memberEmail)
                .boardId(boardId)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public PostUpdateDto toPostUpdateDto(Long postId, PostRequest request) {
        return PostUpdateDto.builder()
                .id(postId)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }
}
