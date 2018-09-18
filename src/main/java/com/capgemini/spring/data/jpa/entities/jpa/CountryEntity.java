
package com.capgemini.spring.data.jpa.entities.jpa;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Table (name="country")
@Entity (name="Country")
public class CountryEntity { 
	
	
	@Id
	@GeneratedValue
	@Basic (optional=false)
    @Column (name="cou_id")
    private Integer id = null;
	
	@Size (max = 10)
	@Column (name="cou_code", nullable=false, length = 10)
	private String  code = null;
	
	@Size (max = 100)
	@Column (name="cou_name", nullable=false, length = 100)
	private String   name = null;

	
	public CountryEntity () {
		
		super ();
	}
	
	public CountryEntity (Integer id, String code, String name) {
		
		super ();
		
		this.id   = id;
		this.code = code;
		this.name = name;
	}

	
	public Integer getId () {

		return this.id;
	}
	
	public void setId (Integer id) {
		
		this.id = id;
	}
	
	public String getCode () {
		
		return this.code;
	}
	
	public void setCode (String code) {
		
		this.code = code;
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
              
        CountryEntity other = (CountryEntity) object;
        if (!this.id.equals (other.getId ())) {  
            return false;  
        }   
        
        return true;
	}
}