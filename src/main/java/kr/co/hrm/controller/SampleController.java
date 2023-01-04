package kr.co.hrm.controller;

import kr.co.hrm.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/list")
    public void getSamples() {
        sampleService.getSamples();
    }

    @GetMapping("/{sampleId}")
    public void getSample(@PathVariable String sampleId) {
        sampleService.getSample(sampleId);
    }

    @PostMapping
    public void createSample(@RequestBody kr.co.hrm.entity.Sample sampleModel) {
        sampleService.createSample(sampleModel);
    }

    @DeleteMapping("/{sampleId}")
    public void removeSample(@PathVariable String sampleId) {
        sampleService.removeSample(sampleId);
    }

    @PatchMapping
    public void modifySample(@RequestBody kr.co.hrm.entity.Sample sampleModel) {
        sampleService.modifySample(sampleModel);
    }

}
