package kr.ac.hs.selab.board.facade;

import kr.ac.hs.selab.board.application.BoardService;
import kr.ac.hs.selab.board.domain.Board;
import kr.ac.hs.selab.board.domain.event.BoardEvent;
import kr.ac.hs.selab.board.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class BoardFacade {
    private final ApplicationEventPublisher publisher;
    private final BoardService boardService;

    @Transactional
    public BoardResponse deleteById(Long id) {
        Board board = boardService.delete(id);
        publisher.publishEvent(BoardEvent.of(board));

        return new BoardResponse(board.getId());
    }
}
