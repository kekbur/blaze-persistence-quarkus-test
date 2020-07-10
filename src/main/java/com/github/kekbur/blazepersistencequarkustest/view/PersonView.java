package com.github.kekbur.blazepersistencequarkustest.view;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.github.kekbur.blazepersistencequarkustest.entity.Person;

import java.util.UUID;

@EntityView(Person.class)
public interface PersonView
{
	@IdMapping
	UUID getId();

	String getName();
}
