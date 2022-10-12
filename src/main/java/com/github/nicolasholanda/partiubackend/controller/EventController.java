package com.github.nicolasholanda.partiubackend.controller;

import com.github.nicolasholanda.partiubackend.model.Event;
import com.github.nicolasholanda.partiubackend.model.builder.LoggedUser;
import com.github.nicolasholanda.partiubackend.service.EventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "eventos")
public class EventController extends BaseController<Event> {

    private final LoggedUser loggedUser;

    public EventController(EventService service, LoggedUser loggedUser) {
        super(service);
        this.loggedUser = loggedUser;
    }

    @Override
    @PostMapping
    public Event save(@RequestBody Event event){
        event.setCreatorId(loggedUser.getId());
        return service.save(event);
    }
}
