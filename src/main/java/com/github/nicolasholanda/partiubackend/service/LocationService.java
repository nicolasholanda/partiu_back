package com.github.nicolasholanda.partiubackend.service;

import com.github.nicolasholanda.partiubackend.model.Location;
import com.github.nicolasholanda.partiubackend.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends BaseService<Location> {

    public LocationService(LocationRepository repository) {
        super(repository);
    }
}
