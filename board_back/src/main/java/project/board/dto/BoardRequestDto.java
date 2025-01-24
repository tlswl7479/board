package project.board.dto;

import lombok.Builder;
import lombok.Getter;
import project.board.domain.Board;
import project.board.vo.BoardRequestVo;

@Getter
public class BoardRequestDto {

	private String title;
	private String content;

	@Builder
	public BoardRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public static BoardRequestDto toDto(BoardRequestVo boardRequestVo) {
		return BoardRequestDto.builder()
			.title(boardRequestVo.getTitle())
			.content(boardRequestVo.getContent())
			.build();
	}

	public Board toEntity() {
		return Board.builder()
			.title(title)
			.content(content)
			.build();
	}

}
