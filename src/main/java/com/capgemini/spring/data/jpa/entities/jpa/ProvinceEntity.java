
package com.capgemini.spring.data.jpa.entities.jpa;



import javax.persistence.*;
import javax.validation.constraints.Size;


@Table (name="province")
@Entity (name="Province")
public class ProvinceEntity {


    @Id
    @GeneratedValue
    @Column (name="pro_id")
    private Integer id = null;

    @ManyToOne (optional=false)
    @JoinColumn (name="cou_id", referencedColumnName="cou_id")
    private CountryEntity country = null;

    @Size (max = 100)
    @Column (name="pro_name", nullable=false, length = 100)
    private String name = null;


    public ProvinceEntity () {

        super ();
    }

    public ProvinceEntity (Integer id, String name, CountryEntity country) {

        super ();

        this.id   = id;
        this.country = country;
        this.name = name;
    }


    public Integer getId () {

        return this.id;
    }

    public void setId (Integer id) {

        this.id = id;
    }

    public CountryEntity getCountry () {

        return this.country;
    }

    public void setCountry (CountryEntity country) {

        this.country = country;
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

        ProvinceEntity other = (ProvinceEntity) object;
        if (!this.id.equals (other.getId ())) {
            return false;
        }

        return true;
    }
}