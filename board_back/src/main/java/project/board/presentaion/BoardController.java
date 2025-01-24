package project.board.presentaion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import project.board.application.BoardService;
import project.board.dto.BoardRequestDto;
import project.board.dto.BoardResponseDto;
import project.board.vo.BoardRequestVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;

	@PostMapping("/create")
	public ResponseEntity createBoard(@RequestBody BoardRequestVo boardRequestVo) {
		BoardRequestDto boardRequestDto = BoardRequestDto.toDto(boardRequestVo);
		boardService.createBoard(boardRequestDto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/read")
	public ResponseEntity<Page<BoardResponseDto>> readAllBoard(
		@RequestParam(value = "page", defaultValue = "0") int page,
		@RequestParam(value = "size", defaultValue = "10") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<BoardResponseDto> boardResponseDto = boardService.readAllBoard(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
	}

	@DeleteMapping("/delete")
	public ResponseEntity deleteBoard(@RequestBody Long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok().build();
	}
}
