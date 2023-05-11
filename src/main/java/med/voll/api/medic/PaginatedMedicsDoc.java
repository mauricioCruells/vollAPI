package med.voll.api.medic;

public record PaginatedMedicsDoc(
        String name,
        String email,
        String description,
        String specialty) {

    public PaginatedMedicsDoc(Medic medic) {
        this(medic.getName(), medic.getEmail(), medic.getDescription(), medic.getSpecialty().toString());
    }
}
