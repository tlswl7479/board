package project.board.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardResponseVo {

	private String title;
	private String content;

	@Builder
	public BoardResponseVo(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public BoardResponseVo toVo() {
		return BoardResponseVo.builder()
			.title(title)
			.content(content)
			.build();
	}

}
