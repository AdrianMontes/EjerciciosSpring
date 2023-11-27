package com.example.controllers;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ResponseBody
	@RequestMapping(value = "/api/users/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Object> getUser(@PathVariable Integer id) {
        String query = "SELECT * FROM springg.usuarios WHERE id_usuarios=?;";
        
        try {
            Map<String, Object> usuario = jdbcTemplate.queryForMap(query, id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);
        } catch (EmptyResultDataAccessException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
	
	@ResponseBody
	@RequestMapping(value = "/api/users/add", method = RequestMethod.PUT)
	public ResponseEntity<Object> addUser(@RequestParam String nombre, @RequestParam Integer edad, @RequestParam String nacionalidad) {
		//Comprobar que estén todos los parámetros
		if (nombre.isEmpty() || edad == null || nacionalidad.isEmpty()) {
			return new ResponseEntity<Object>("Te faltan parámetros. Asegúrate de poner nombre, edad y nacionalidad.", HttpStatus.BAD_REQUEST);
		}
		
		//Añadir al usuario
		String query = "INSERT INTO springg.usuarios (nombre, edad, nacionalidad) VALUES (?, ?, ?);";
		jdbcTemplate.update(query, nombre, edad, nacionalidad);
		String mensaje = "Usuario creado\nNombre: " + nombre + "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad;
		return new ResponseEntity<Object>(mensaje, HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/users/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestParam String nombre, @RequestParam Integer edad, @RequestParam String nacionalidad) {
		if (nombre.isEmpty() || edad == null || nacionalidad.isEmpty()) {
			return new ResponseEntity<Object>("Te faltan parámetros. Asegúrate de poner nombre, edad y nacionalidad.", HttpStatus.BAD_REQUEST);
		}
		
		//Actualizar usuario
		String query = "UPDATE springg.usuarios SET nombre=?, edad=?, nacionalidad=? WHERE id_usuarios=?;";
		jdbcTemplate.update(query, nombre, edad, nacionalidad, id);
		String mensaje = "Usuario actualizado\nNombre: " + nombre + "\nEdad: " + edad + "\nNacionalidad: " + nacionalidad;
		return new ResponseEntity<Object>(mensaje, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/users/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
	    String query = "DELETE FROM springg.usuarios WHERE id_usuarios=?";
	    
	    int deletedRows = jdbcTemplate.update(query, id);

	    if (deletedRows > 0) {
	        Map<String, String> response = new HashMap<>();
	        response.put("Borrado", "Usuario borrado");
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } else {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", "Usuario no encontrado");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	    }
	}

}
