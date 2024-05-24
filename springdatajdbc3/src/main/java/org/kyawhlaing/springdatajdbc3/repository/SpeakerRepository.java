package org.kyawhlaing.springdatajdbc3.repository;

import org.kyawhlaing.springdatajdbc3.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();

    Speaker create(Speaker speaker);

    Speaker getSpeaker(int id);

    Speaker update(Speaker speaker);

    void update(List<Object[]> pairs);

    void delete(int id);
}
