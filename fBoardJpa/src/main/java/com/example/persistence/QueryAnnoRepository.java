package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface QueryAnnoRepository extends CrudRepository<BoardVO, Integer>{

	// [1] JPQL (복잡한 쿼리문 사용 시) SQL문장 아님 주의 !!
	@Query("SELECT b FROM BoardVO b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<BoardVO> queryAnnotation(String word);
	
	// [2] SQL (복잡한 쿼리의 경우 직접 작성 - 조인하는 경우)
	@Query(value="SELECT * FROM board  "
					+ "		WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC",nativeQuery=true)
	List<BoardVO> queryAnnotation2(String word);

	// 	숙) board2와 board_file
	// 	레코드 리턴 값이 BoardVO로 나오지 않음 -> Object[] or HashMap 등으로 처리
	
	@Query(value="SELECT seq, title, writer, regdate, cnt FROM board WHERE title LIKE '%'||?1||'%' ORDER BY seq DESC",nativeQuery=true)
	List<BoardVO> queryAnnotation3(String word);
	
} // end of interface