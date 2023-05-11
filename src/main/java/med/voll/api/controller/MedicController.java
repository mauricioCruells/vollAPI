package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medic.CreateMedicDto;
import med.voll.api.medic.Medic;
import med.voll.api.medic.MedicRepository;
import med.voll.api.medic.PaginatedMedicsDoc;

@RestController
@RequestMapping("api/v1/medics")
public class MedicController {

    @Autowired
    private MedicRepository medicRepository;

    @PostMapping
    public void createOneMedic(@RequestBody @Valid CreateMedicDto medicInfo) {
        Medic medic = new Medic(medicInfo);
        medicRepository.save(medic);
    }

    @GetMapping
    public List<PaginatedMedicsDoc> getMedicsPaginated() {
        return medicRepository.findAll().stream().map(PaginatedMedicsDoc::new).toList();
    }
}
