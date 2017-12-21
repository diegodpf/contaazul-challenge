package com.contaazul.resources.mars;

import com.contaazul.domain.mars.Coordinate;
import com.contaazul.domain.mars.MarsService;
import com.contaazul.domain.mars.Movement;
import com.contaazul.validator.MovementCommands;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/rest/mars")
public class MarsResource {
    private final MarsService service;

    public MarsResource(MarsService service) {
        this.service = service;
    }

    @PostMapping("/{commands}")
    public ResponseEntity<String> moveRobot(@PathVariable @MovementCommands String commands) {
        List<Movement> movements  = commands
                .chars()
                .mapToObj(c -> Movement.fromCommand((char) c))
                .collect(Collectors.toList());

        Coordinate coordinate = service.moveRobot(movements);

        return ResponseEntity.ok(coordinate.toString());
    }
}
