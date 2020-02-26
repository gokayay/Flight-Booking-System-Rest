package com.airlines.automationsystem.controller;

import com.airlines.automationsystem.model.Route;
import com.airlines.automationsystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    // GET

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Route>> findAllRoutes() {

        return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> findOneRoute(@PathVariable Long id) {

        return new ResponseEntity(routeService.getOneRoute(id), HttpStatus.OK);
    }

    // POST

    @PostMapping(value = "")
    public ResponseEntity<String> create(@RequestBody Route route) {
        routeService.createRoute(route);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  delete(@PathVariable  Long id) {
        routeService.deleteRoute(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // PUT

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable  Long id,@RequestBody  Route route){
        routeService.updateRoute(id,route);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }
}
