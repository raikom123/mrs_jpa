package mrs.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if (attribute == null) {
            return null;
        }
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return dbData.toLocalDate();
    }

}
