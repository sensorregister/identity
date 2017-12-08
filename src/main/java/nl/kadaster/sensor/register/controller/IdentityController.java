package nl.kadaster.sensor.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.kadaster.sensor.register.entity.Identity;
import nl.kadaster.sensor.register.model.CodeRegistration;
import nl.kadaster.sensor.register.repository.IdentityRepository;

@RestController
public class IdentityController {

	private IdentityRepository identityRepository;

	@Autowired
	public IdentityController(IdentityRepository identityRepository) {
		this.identityRepository = identityRepository;
	}

	@GetMapping(value = "/identities/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> get(@PathVariable long id) {
		Identity identity = identityRepository.findOne(id);
		if (identity != null) {
			return new ResponseEntity<>(identity, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}