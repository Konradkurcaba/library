package Dtos;

public interface DtoWithCa {
    DtoCaValue getCaValue(DtoType aExpectedDto);
    void setCaValue(DtoCaValue aNewDtoValue);
}
