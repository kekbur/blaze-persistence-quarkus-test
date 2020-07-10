package com.github.kekbur.blazepersistencequarkustest.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private String name;
	private long age;
	
	public Person()
	{
		id = UUID.randomUUID();
	}
	
	public Person(String name)
	{
		this();
		this.name = name;
	}
	
	public Person(String name, long age)
	{
		this.name = name;
		this.age = age;
	}
	
	@Id
	public UUID getId()
	{
		return id;
	}
	
	public void setId(UUID id)
	{
		this.id = id;
	}
	
	@Basic(optional = false)
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public long getAge()
	{
		return age;
	}
	
	public void setAge(long age)
	{
		this.age = age;
	}
}
