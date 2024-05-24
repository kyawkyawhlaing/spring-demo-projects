package org.kyawhlaing.springdatajdbc3.service;

import org.kyawhlaing.springdatajdbc3.model.Speaker;
import org.kyawhlaing.springdatajdbc3.repository.SpeakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements ISpeakerService {
    private SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public List<Speaker> findAll() {
        return null;
    }

    @Override
    public Speaker create(Speaker speaker) {
        return null;
    }
}
