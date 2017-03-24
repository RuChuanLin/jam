package _999_test.hbm_xml;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


public class One implements java.io.Serializable {

	private Integer oneId;	
	private Set<Many> many = new HashSet<Many>(0);
	public One(Integer oneId, Set<Many> many) {
		super();
		this.oneId = oneId;
		this.many = many;
	}
	public One() {
		super();
	}
	public Integer getOneId() {
		return oneId;
	}
	public void setOneId(Integer oneId) {
		this.oneId = oneId;
	}
	public Set<Many> getMany() {
		return many;
	}
	public void setMany(Set<Many> many) {
		this.many = many;
	}


}
