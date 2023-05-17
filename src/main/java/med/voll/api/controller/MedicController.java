package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import med.voll.api.medic.CreateMedicDto;
import med.voll.api.medic.DeactivateMedicDto;
import med.voll.api.medic.Medic;
import med.voll.api.medic.MedicRepository;
import med.voll.api.medic.PaginatedMedicsDoc;
import med.voll.api.medic.UpdateMedicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/v1/medics")
public class MedicController {
  @Autowired
  private MedicRepository medicRepository;

  @PostMapping
  public ResponseEntity<PaginatedMedicsDoc> createOneMedic(
    @RequestBody @Valid CreateMedicDto medicInfo,
    UriComponentsBuilder uriComponentsBuilder
  ) {
    Medic medic = new Medic(medicInfo);
    medicRepository.save(medic);

    PaginatedMedicsDoc responseMedic = new PaginatedMedicsDoc(medic);

    URI newMedicURI = uriComponentsBuilder
      .path("/medics/{id}")
      .buildAndExpand(medic.getId())
      .toUri();

    return ResponseEntity.created(newMedicURI).body(responseMedic);
  }

  @GetMapping
  public ResponseEntity<Page<PaginatedMedicsDoc>> getMedicsPaginated(
    @PageableDefault(size = 4) Pageable pageable
  ) {
    return ResponseEntity.ok(
      medicRepository.findAll(pageable).map(PaginatedMedicsDoc::new)
    );
  }

  @GetMapping("{id}")
  public ResponseEntity<PaginatedMedicsDoc> getOneMedic(@PathVariable long id) {
    Medic medic = medicRepository.getReferenceById(id);

    PaginatedMedicsDoc responseMedic = new PaginatedMedicsDoc(medic);

    return ResponseEntity.ok(responseMedic);
  }

  @PutMapping("{id}")
  @Transactional
  public ResponseEntity<PaginatedMedicsDoc> updateOneMedic(
    @PathVariable long id,
    @RequestBody @Valid UpdateMedicDto updateMedicDto
  ) {
    Medic medic = medicRepository.getReferenceById(id);
    medic.updateMedic(updateMedicDto);

    PaginatedMedicsDoc responseMedic = new PaginatedMedicsDoc(medic);

    return ResponseEntity.ok(responseMedic);
  }

  @DeleteMapping("{id}")
  @Transactional
  public ResponseEntity<PaginatedMedicsDoc> deactivateOneMedic(
    @PathVariable long id,
    @RequestBody @Valid DeactivateMedicDto deactivateMedicDto
  ) {
    Medic medic = medicRepository.getReferenceById(id);
    medic.deactivate(deactivateMedicDto);
    return ResponseEntity.noContent().build();
  }
}
