package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = "/usuarios/get", method = RequestMethod.GET)
	public List<String> getUsers() {
		final String query = "SELECT * FROM spring.usuarios;";
		
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(query);
		
		List<String> lista = new ArrayList<String>();
		
		for(Map<String, Object> row: resultados) {
			lista.add(row.toString());
		}
		
		return lista;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usuarios/get/{id}", method = RequestMethod.GET)
	public Map<String, Object> getUser(@PathVariable Integer id) {
		String query = "SELECT * FROM spring.usuarios WHERE id_usuarios=?;";
		Map<String, Object> usuario = jdbcTemplate.queryForMap(query, id);
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usuarios/add", method = RequestMethod.POST)
	public Map<String, Object> addUser(@RequestParam String nombre, @RequestParam Integer edad, @RequestParam String nacionalidad) {
		//Añadiendo usuario
		String query1 = "INSERT INTO spring.usuarios (nombre, edad, nacionalidad) VALUES (?, ?, ?);";
		jdbcTemplate.update(query1, nombre, edad, nacionalidad);
		
		//Mostrar el usuario recién añadido
		String ultimoId = "SELECT LAST_INSERT_ID() as id_usuarios;";
		Integer id = jdbcTemplate.queryForObject(ultimoId, Integer.class);
		String query2 = "SELECT * FROM spring.usuarios WHERE id_usuarios=?;";
		Map<String, Object> usuario = jdbcTemplate.queryForMap(query2, id);
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usuarios/update/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updateUser(@PathVariable Integer id, @RequestParam String nombre, @RequestParam Integer edad, @RequestParam String nacionalidad) {
		//Actualizar usuario
		String query1 = "UPDATE spring.usuarios SET nombre=?, edad=?, nacionalidad=? WHERE id_usuarios=?;";
		jdbcTemplate.update(query1, nombre, edad, nacionalidad, id);
		
		//Mostrar el usuario recién añadido
		String ultimoId = "SELECT LAST_INSERT_ID() as id_usuarios;";
		String query2 = "SELECT * FROM spring.usuarios WHERE id_usuarios=?;";
		Map<String, Object> usuario = jdbcTemplate.queryForMap(query2, id);
		return usuario;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usuarios/delete/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Integer id) {
		String query = "DELETE FROM spring.usuarios WHERE id_usuarios=?";
		jdbcTemplate.update(query, id);
		return "Usuario borrado";
	}
}
