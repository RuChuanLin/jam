package _999_test.hbm_xml;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

public class Many implements java.io.Serializable {

	private int manyId;
//	private One one;

	public int getManyId() {
		return manyId;
	}

	public void setManyId(int manyId) {
		this.manyId = manyId;
	}

	public Many(int manyId) {
		super();
		this.manyId = manyId;
	}

	public Many() {
		super();
	}

}
