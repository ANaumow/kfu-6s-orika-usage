package ru.itis.demo.mappers;

import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;
import ru.itis.demo.domain.Student;
import ru.itis.demo.dto.StudentDto;

@Component
public class StudentMapperFactory implements MapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Student.class, StudentDto.class)
                .byDefault()
                .field("group.groupName", "groupName")
                .register();
    }
}
