
package com.capgemini.spring.data.jpa.entities.jpa;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Table (name="city")
@Entity (name="City")
public class CityEntity { 
	
	
	@Id
	@GeneratedValue
	@Column (name="cit_id")
    private Integer id = null;
	
	@ManyToOne (optional=false)
	@JoinColumn (name="pro_id", referencedColumnName="pro_id")
	private ProvinceEntity province = null;
	
	@Size (max = 100)
	@Column (name="cit_name", nullable=false, length = 100)
	private String name = null;
	
	
	public CityEntity () {
		
		super ();
	}
	
	public CityEntity (Integer id, ProvinceEntity province, String name) {
		
		super ();
		
		this.id       = id;
		this.province = province;
		this.name = name;
	}

	
	public Integer getId () {

		return this.id;
	}
	
	public void setId (Integer id) {
		
		this.id = id;
	}
	
	public ProvinceEntity getProvince () {
		
		return this.province;
	}
	
	public void setCountry (ProvinceEntity province) {
		
		// Set the value.
		this.province = province;
	}
	
	public String getName () {
		
		return this.name;
	}
	
	public void setName (String name) {
		
		this.name = name;
	}
	
	
	@Override
	public int hashCode () {
		
		int hash = 0;
        hash += (this.getId () != null ? this.getId ().hashCode () : 0);  
  
        return hash;
	}

	@Override
	public boolean equals (Object object) {
		
		if (this == object)  {
			return true;
		}
              
        if (object == null) {
        	return false;
        }  
              
        if (getClass () != object.getClass ()) {
        	return false;
        }  
              
        CityEntity other = (CityEntity) object;
        if (!this.id.equals (other.getId ())) {  
            return false;  
        }  
        
        return true;
	}
}