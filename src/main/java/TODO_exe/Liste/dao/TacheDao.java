package TODO_exe.Liste.dao;

import TODO_exe.Liste.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheDao extends JpaRepository<Tache, Integer> {

}
