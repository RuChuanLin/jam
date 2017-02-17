package _999_test.hbm_ano;

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

@Entity
@Table(name = "one")
public class One implements java.io.Serializable {

	private Integer oneId;
	// 所謂一對多中的"一", 指的是"多"的集合, 所以要用Set
	private Set<Many> many = new HashSet<Many>(0);

	public One() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ONE_ID", unique = true, nullable = false)
	public Integer getOneId() {
		return oneId;
	}

	public void setOneId(Integer oneId) {
		this.oneId = oneId;
	}

	/*
	 * mappedBy的含義 https://my.oschina.net/zhuzhiqiang/blog/671643
	 * mappedBy的意思就是「被映射」，即mappedBy這方不用管關聯關係，關聯關係交給另一方處理
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "one")
	public Set<Many> getMany() {
		return many;
	}

	public void setMany(Set<Many> many) {
		this.many = many;
	}

}
