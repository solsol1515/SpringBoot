import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.EmpVO;

public class EmpMain {

	public static void main(String[] args) {
		
		// 1. 엔티티 매니저 팩토리 생성 (persistence와 연결됨)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aBasic");
		
		// 2. 엔티티 매니저
		EntityManager em = emf.createEntityManager();
		
		// 4-1. 엔티티 트랜잭션 생성 
		EntityTransaction tx = em.getTransaction();
		
		try{
			// 3. 엔티티 생성
			EmpVO vo = new EmpVO();
			vo.setEmpno(1210);
			vo.setName("맹맹");
			vo.setHiredate(new Date());
			vo.setDeptno(99);
			// 4-2. 트랜잭션 처리
			tx.begin();
			
			em.persist(vo);
			tx.commit();
		}catch(Exception ex) {
			System.out.println("실패:" + ex.getMessage());
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}

}
