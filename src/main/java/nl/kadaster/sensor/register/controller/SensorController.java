package nl.kadaster.sensor.register.controller;

import nl.kadaster.sensor.register.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import nl.kadaster.sensor.register.entity.Code;
import nl.kadaster.sensor.register.entity.Sensor;
import nl.kadaster.sensor.register.model.SensorInfo;
import nl.kadaster.sensor.register.repository.CodeRepository;
import nl.kadaster.sensor.register.repository.SensorRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SensorController {

	private SensorRepository sensorRepository;
	private CodeRepository codeRepository;

	@Autowired
	public SensorController(SensorRepository sensorRepository, CodeRepository codeRepository) {
		this.sensorRepository = sensorRepository;
		this.codeRepository = codeRepository;
	}

	@PostMapping(path = "/sensors/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody SensorInfo sensorInfo) {

		Code code = codeRepository.findOneByValue(sensorInfo.getCodeValue());
		code.setStatus(Status.ACTIVATED);
		Sensor sensor = Sensor.from(sensorInfo, code);

		try {
			sensorRepository.save(sensor);
		} catch (Exception e) {
			return new ResponseEntity<>("Sensor is al gekoppeld aan een Code!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(sensor, HttpStatus.OK);
	}

    @GetMapping(path = "/sensors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSensor(@RequestParam(value="code", required = true)  String code) {

        Sensor sensor = sensorRepository.findOneByCode_Value(code);

        return new ResponseEntity<>(sensor, HttpStatus.OK);
    }

}
