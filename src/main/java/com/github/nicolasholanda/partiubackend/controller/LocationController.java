package com.github.nicolasholanda.partiubackend.controller;

import com.github.nicolasholanda.partiubackend.model.Location;
import com.github.nicolasholanda.partiubackend.service.LocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "locais")
public class LocationController extends BaseController<Location> {

    public LocationController(LocationService service) {
        super(service);
    }
}
