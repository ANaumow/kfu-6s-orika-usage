package ru.itis.demo.mappers;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;
import ru.itis.demo.domain.Group;
import ru.itis.demo.dto.GroupDto;
import ru.itis.demo.dto.GroupWithStudentsDto;

@Component
public class GroupMapperFactory implements MapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Group.class, GroupDto.class)
                .exclude("headman")
                .byDefault()
                .customize(new CustomMapper<Group, GroupDto>() {
                    @Override
                    public void mapAtoB(Group group, GroupDto groupDto, MappingContext context) {
                        groupDto.setHeadman(group.getHeadman().getFirstname() + " " + group.getHeadman().getLastname());
                    }
                })
                .register();

        mapperFactory.classMap(Group.class, GroupWithStudentsDto.class)
                .use(Group.class, GroupDto.class)
                .byDefault()
                .register();
    }

}
