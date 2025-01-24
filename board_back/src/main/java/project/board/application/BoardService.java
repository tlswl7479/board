package project.board.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.board.domain.Board;
import project.board.dto.BoardRequestDto;
import project.board.dto.BoardResponseDto;
import project.board.infrastructure.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	public void createBoard(BoardRequestDto boardRequestDto) {
		boardRepository.save(boardRequestDto.toEntity());
	}

	public Page<BoardResponseDto> readAllBoard(Pageable pageable) {
		Page<Board> boardList = boardRepository.findAll(pageable);
		return boardList.map(BoardResponseDto::toDto);
	}

	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}

}
