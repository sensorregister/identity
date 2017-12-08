package nl.kadaster.sensor.register.controller;

import nl.kadaster.sensor.register.entity.Identity;
import nl.kadaster.sensor.register.model.CodeRegistration;
import nl.kadaster.sensor.register.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.kadaster.sensor.register.repository.CodeRepository;

@RestController
public class CodeController {

	private CodeRepository codeRepository;
	private IdentityRepository identityRepository;

	@Autowired
	public CodeController(CodeRepository codeRepository, IdentityRepository identityRepository) {
		this.codeRepository = codeRepository;
		this.identityRepository = identityRepository;
	}

	@GetMapping(value = "/codes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCodes(@PathVariable Long id) {
		return new ResponseEntity<>(codeRepository.findOne(id), HttpStatus.OK);
	}

	@PostMapping(path = "/codes/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody CodeRegistration codeRegistration) {

		Identity identity = Identity.from(codeRegistration);
		try {
			identity = identityRepository.save(identity);
		} catch (Exception e) {
			return new ResponseEntity<>("Code is al gekoppeld aan een telefoonnummer!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
