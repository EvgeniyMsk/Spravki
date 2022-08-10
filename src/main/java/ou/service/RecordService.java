package ou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ou.entity.RecordSpravka;
import ou.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<RecordSpravka> getAllRecords() {
        return recordRepository.findAll();
    }

    public void addRecord(RecordSpravka recordSpravka) {
        this.recordRepository.save(recordSpravka);
    }

    public void deleteRecord(String id) {
        recordRepository.deleteById(Long.parseLong(id));
    }
}
