package com.github.nicolasholanda.partiubackend.controller;

import com.github.nicolasholanda.partiubackend.model.Event;
import com.github.nicolasholanda.partiubackend.service.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "eventos")
public class EventController extends BaseController<Event> {

    public EventController(EventService service) {
        super(service);
    }
}
