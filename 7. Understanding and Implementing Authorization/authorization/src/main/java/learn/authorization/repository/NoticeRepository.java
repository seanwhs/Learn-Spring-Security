//NoticeRepository.java
package learn.authorization.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learn.authorization.model.Notice;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {
	//filter out expired queries
	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notice> findAllActiveNotices();

}