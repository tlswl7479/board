package project.board.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.board.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
