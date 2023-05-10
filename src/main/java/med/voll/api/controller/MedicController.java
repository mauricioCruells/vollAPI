package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medic.CreateMedicDto;

@RestController
@RequestMapping("api/v1/medics")
public class MedicController {
    @PostMapping
    public CreateMedicDto createOneMedic(@RequestBody CreateMedicDto medicInfo) {
        return medicInfo;
    }
}
