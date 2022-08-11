package com.github.nicolasholanda.partiubackend.service;

import com.github.nicolasholanda.partiubackend.model.Event;
import com.github.nicolasholanda.partiubackend.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseService<Event> {

    public EventService(EventRepository repository) {
        super(repository);
    }
}
