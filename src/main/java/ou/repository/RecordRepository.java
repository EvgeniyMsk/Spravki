package ou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ou.entity.RecordSpravka;

@Repository
public interface RecordRepository extends JpaRepository<RecordSpravka, Long> {
}
