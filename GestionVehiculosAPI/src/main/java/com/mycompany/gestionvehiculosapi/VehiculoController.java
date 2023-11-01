/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionvehiculosapi;

/**
 *
 * @author alanl
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping
    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    @PostMapping
    public void agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

@PutMapping("/{placa}")
public void actualizarVehiculo(@PathVariable String placa, @RequestBody Vehiculo vehiculo) {
    Vehiculo vehiculoExistente = vehiculoRepository.findByPlaca(placa);
    
    if (vehiculoExistente != null) {
        vehiculoExistente.setModelo(vehiculo.getModelo());
        vehiculoExistente.setColor(vehiculo.getColor());
        vehiculoExistente.setPuertas(vehiculo.getPuertas());
        
        vehiculoRepository.save(vehiculoExistente);
    } else {
      
    }
}

    }


   

