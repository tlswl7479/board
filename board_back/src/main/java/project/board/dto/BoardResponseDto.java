package project.board.dto;

import lombok.Builder;
import lombok.Getter;
import project.board.domain.Board;

@Getter
public class BoardResponseDto {

	private Long id;
	private String title;
	private String content;

	@Builder
	public BoardResponseDto(Long id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public static BoardResponseDto toDto(Board board) {
		return BoardResponseDto.builder()
			.id(board.getId())
			.title(board.getTitle())
			.content(board.getContent())
			.build();
	}

}
