package med.voll.api.medic;

public record PaginatedMedicsDoc(
        Long id,
        String name,
        String email,
        String description,
        String specialty) {

    public PaginatedMedicsDoc(Medic medic) {
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getDescription(), medic.getSpecialty().toString());
    }
}
