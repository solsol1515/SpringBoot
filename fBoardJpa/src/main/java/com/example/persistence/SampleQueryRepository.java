package com.example.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface SampleQueryRepository extends CrudRepository<BoardVO, Integer>{
	
	// 제목 검색
	List<BoardVO> findBoardVOByTitle(String title);
	
	// 제목에 '구' 글자 포함 검색
	List<BoardVO> findBoardVOByTitleContaining(String word);
	
	// 전체 검색 페이징
	List<BoardVO> findAll(Pageable paging);
	
} // end of class

/*	조건 검색 				==> 			쿼리 메소드
	
	WHERE title=?1						findBoardVOByTitle() (BoardVO 생략 가능)
	WHERE lastname=?1					findByLastname()
	WHERE lastname<>?1					findByLastnameNot()
	where lastname=?1 and firstname=?2	findByLastnameAndFirstname()
	where startDate between ?1 and ?2	findByStartDateBetween()
	where age < ?1						findByAgeLessThan()
	where age <= ?1						findByAgeLessThanEqual()
	where age > ?1						findByAgeGreatThan()
	where age >= ?1						findByAgeGreatThanEqual()
	where age is null					findByAgeIsNull()
	where age is not null				findByAgeIsNotNull()
	where firstname like '%'||?||'%'	findByFirstnameContaining()
	where age =?1 order by lastname desc
										findByAgeOrderByLastnameDesc()
*/