package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medic.CreateMedicDto;
import med.voll.api.medic.DeactivateMedicDto;
import med.voll.api.medic.Medic;
import med.voll.api.medic.MedicRepository;
import med.voll.api.medic.PaginatedMedicsDoc;
import med.voll.api.medic.UpdateMedicDto;

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
    public Page<PaginatedMedicsDoc> getMedicsPaginated(@PageableDefault(size = 4) Pageable pageable) {
        return medicRepository.findAll(pageable).map(PaginatedMedicsDoc::new);
    }

    @PutMapping("{id}")
    @Transactional
    public void updateOneMedic(@PathVariable long id, @RequestBody @Valid UpdateMedicDto updateMedicDto) {
        Medic medic = medicRepository.getReferenceById(id);
        medic.updateMedic(updateMedicDto);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deactivateOneMedic(@PathVariable long id, @RequestBody @Valid DeactivateMedicDto deactivateMedicDto) {
        Medic medic = medicRepository.getReferenceById(id);
        medic.deactivate(deactivateMedicDto);
    }
}
