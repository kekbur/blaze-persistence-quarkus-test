package com.github.kekbur.blazepersistencequarkustest.view;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.UpdatableEntityView;
import com.github.kekbur.blazepersistencequarkustest.entity.Person;

@UpdatableEntityView
@CreatableEntityView
@EntityView(Person.class)
public interface PersonUpdateView extends PersonView
{
	void setName(String name);
}
