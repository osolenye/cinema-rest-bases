package com.example.cinema.base;

import com.example.cinema.exceptions.FindByIdException;
import com.example.cinema.models.enums.Language;
import com.example.cinema.models.responses.Response;
import com.example.cinema.utils.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class BaseServiceImpl<E extends BaseEntity,
        R extends BaseRep<E>,
        D extends BaseDto,
        M extends BaseMapper<E, D>>
        implements BaseService<D> {
    protected final R r;
    protected final M mapper;
    @Autowired
    protected CycleAvoidingMappingContext context;
    private D d;

    public BaseServiceImpl(R r, M mapper, CycleAvoidingMappingContext context) {
        this.r = r;
        this.mapper = mapper;
        this.context = context;
    }


    @Override
    public D save(D d) {
        return mapper.toDto(r.save(mapper.toEntity(d, context)),context);
    }


    @Override
    public D findById(Long id, Language language) {
//        return mapper.toDto(r.findById(id).orElseThrow(() -> new FindByIdException(ResourceBundle("idNotFound", language))), context);
        return mapper.toDto(r.findById(id).orElseThrow(()-> new FindByIdException(ResourceBundle.periodMess("idNotFound", language))), context);

    }

    @Override
    public List<D> findAll() {
        return mapper.toDtos(r.findAll(), context);
    }

    @Override
    public D update(D d) {
        return mapper.toDto(r.saveAndFlush(mapper.toEntity(d, context)), context);
    }

    @Override
    public boolean delete(D d) {
        try {
            d.setActive(false);
            save(d);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("couldn't delete the object");
        }
    }
}
