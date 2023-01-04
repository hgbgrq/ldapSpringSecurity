package kr.co.hrm.service;

import kr.co.hrm.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public void getSamples() {
        try {
            Iterable<kr.co.hrm.entity.Sample> samples = sampleRepository.findAll();
            log.info("getSamples ? : {}", samples);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSample(String sampleId) {
        try {
            Optional<kr.co.hrm.entity.Sample> sampleEntity = sampleRepository.findById(sampleId);
            log.info("getSample ? : {}" , sampleEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSample(kr.co.hrm.entity.Sample sampleEntity) {
        try {
            sampleRepository.save(sampleEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeSample(String sampleId) {
        try {
            sampleRepository.deleteById(sampleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifySample(kr.co.hrm.entity.Sample sampleEntity) {
        try {
            sampleRepository.save(sampleEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
