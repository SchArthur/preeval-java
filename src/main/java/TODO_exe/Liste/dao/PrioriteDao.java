package TODO_exe.Liste.dao;

import TODO_exe.Liste.model.Priorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrioriteDao extends JpaRepository<Priorite, Integer> {

}
