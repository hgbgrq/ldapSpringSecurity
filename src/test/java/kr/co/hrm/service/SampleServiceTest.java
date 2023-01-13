package kr.co.hrm.service;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith( SpringRunner.class )
@SpringBootTest
class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    String beforeCreateSample() {
        kr.co.hrm.entity.Sample sampleEntity = kr.co.hrm.entity.Sample.builder()
            .id(UUID.randomUUID().toString())
            .sampleCol("beforeCreateSample")
            .build();
        sampleService.createSample(sampleEntity);
        return sampleEntity.getId();
    }

    @Test
    void getSamples() {
        beforeCreateSample();
        sampleService.getSamples();
    }

    @Test
    void getSample() {
        String id = beforeCreateSample();
        sampleService.getSample(id);
    }

    @Test
    void getSamplesBySampleColLike() {
        beforeCreateSample();
        sampleService.getSamplesBySampleColLike("Create");
    }

    @Test
    void createSample() {
        kr.co.hrm.entity.Sample sampleEntity = kr.co.hrm.entity.Sample.builder()
            .id(UUID.randomUUID().toString())
            .sampleCol("createSample")
            .build();
        sampleService.createSample(sampleEntity);
        sampleService.getSample(sampleEntity.getId());
    }

    @Test
    void removeSample() {
        String id = beforeCreateSample();
        sampleService.getSamples();
        sampleService.removeSample(id);
        sampleService.getSamples();

    }

    @Test
    void modifySample() {
        String id = beforeCreateSample();
        sampleService.getSample(id);
        kr.co.hrm.entity.Sample sampleEntity = kr.co.hrm.entity.Sample.builder()
            .id(id)
            .sampleCol("modifySample")
            .build();
        sampleService.modifySample(sampleEntity);
        sampleService.getSample(id);
    }
}
