package org.kyawhlaing.springdatajdbc3.controller;

import org.kyawhlaing.springdatajdbc3.model.Speaker;
import org.kyawhlaing.springdatajdbc3.service.ISpeakerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakerController {
    private final ISpeakerService iSpeakerService;
    public SpeakerController(ISpeakerService iSpeakerService) { this.iSpeakerService=iSpeakerService; }

    @PutMapping
    public Speaker createSpeaker(@RequestBody Speaker speaker)
    {
        System.out.println("Name: " + speaker.getName());
        return null;
    }


}
