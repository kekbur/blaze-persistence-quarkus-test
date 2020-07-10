package com.github.kekbur.blazepersistencequarkustest.resource;

import java.util.Random;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.blazebit.persistence.integration.jaxrs.EntityViewId;
import com.blazebit.persistence.view.EntityViewManager;
import com.github.kekbur.blazepersistencequarkustest.entity.Person;
import com.github.kekbur.blazepersistencequarkustest.view.PersonUpdateView;
import com.github.kekbur.blazepersistencequarkustest.view.PersonView;

@Path("/persons")
public class PersonResource
{
	@Inject
	EntityManager em;
	
	@Inject
	EntityViewManager evm;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public PersonView createAndGetPerson()
	{
		Person person = new Person("P" + new Random().nextInt(), new Random().nextLong());
		person.setId(UUID.randomUUID());
		em.persist(person);
		return evm.find(em, PersonView.class, person.getId());
	}
	
	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PersonView updatePerson(@EntityViewId("id") PersonUpdateView personUpdateView)
	{
		if (personUpdateView.getId() == null)
		{
			throw new BadRequestException("Id is null");
		}
		
		evm.save(em, personUpdateView);
		return evm.find(em, PersonView.class, personUpdateView.getId());
	}
}
