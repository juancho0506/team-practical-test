/**
 * 
 */
package com.team.business.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Rodrigo
 * Client Entity bean to represent a client in the persistence context
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.findByClientId",
            query = "   SELECT c "
            + " FROM Client c "
            + " WHERE c.clientId = :clientId "),
    @NamedQuery(name = "Client.findAll",
    query = "   SELECT c "
    + " FROM Client c "
    + " ORDER BY c.name ")
})
@Table(name="client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** The auto generated id **/
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The client unique Id in the real world.
	 */
	@Column
	private Integer clientId;
	
	@Column
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private String address;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
