package org.kyawhlaing.springdatajdbc3.service;

import org.kyawhlaing.springdatajdbc3.model.Speaker;

import java.util.List;

public interface ISpeakerService {

    List<Speaker> findAll();
    Speaker create(Speaker speaker);
}
