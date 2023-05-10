package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.medic.CreateMedicDto;
import med.voll.api.medic.Medic;
import med.voll.api.medic.MedicRepository;

@RestController
@RequestMapping("api/v1/medics")
public class MedicController {

    @Autowired
    private MedicRepository medicRepository;

    @PostMapping
    public void createOneMedic(@RequestBody CreateMedicDto medicInfo) {
        Medic medic = new Medic(medicInfo);
        medicRepository.save(medic);
    }
}
