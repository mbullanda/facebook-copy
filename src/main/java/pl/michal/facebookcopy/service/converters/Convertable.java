package pl.michal.facebookcopy.service.converters;

public interface Convertable<DOT_INPUT_TYPE, ENTITY, DTO_OUTPUT_TYPE> {

    ENTITY fromDto(DOT_INPUT_TYPE input);

    DTO_OUTPUT_TYPE toDto(ENTITY entity);
}
