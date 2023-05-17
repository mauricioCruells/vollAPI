package med.voll.api.medic;

public record PaginatedMedicsDoc(
        Long id,
        String name,
        String email,
        String description,
        Boolean active,
        String specialty) {

    public PaginatedMedicsDoc(Medic medic) {
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getDescription(), medic.getActive(),
                medic.getSpecialty().toString());
    }
}
