package com.kodilla.hibernate.triggerTestEntitty.dao;

import com.kodilla.hibernate.triggerTestEntitty.TriggerEntity;
import org.springframework.data.repository.CrudRepository;

public interface TriggerEntityDao extends CrudRepository<TriggerEntity, Integer> {
}
