package com.example.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Integer>{

}
/*
 	CrudRepository<T,ID>
 		T  : 엔티티 클래스 타입
 		ID : 식별자 타입
 		
 		- long count()
 		- void deleteById(ID)		삭제
 		- void deleteAll()			전체 삭제
 		- boolean existsById(ID) 	해당하는지 여부
 		- Iterable<T> findAll()		전체 가져오기
 		- Optional<T> findById(ID)	하나 가져오기
 		- <S extends T>save(S)		T를 상속받은 S
*/
