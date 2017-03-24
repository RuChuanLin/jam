package _999_test.hbm_ano;

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

/*
本份java檔會產生以下SQL指令
CREATE TABLE `many` (  <===== 31行 @Table(name = "many")
  `MANY_ID` int(11) NOT NULL AUTO_INCREMENT,  <===== @Column(name = "MANY_ID", unique = true, nullable = false)
  `DATE` date NOT NULL,
  `ONE_ID` int(11) NOT NULL,  <=====重點!!66~67行
  PRIMARY KEY (`MANY_ID`), <===== 55行 @Id
  UNIQUE KEY `UK_euuj9ltdqtiqcslicrf4u8tc2` (`DATE`),
  KEY `FK_bldqs62mijg1yod1nofost45t` (`ONE_ID`),
  CONSTRAINT `FK_bldqs62mijg1yod1nofost45t` FOREIGN KEY (`ONE_ID`) REFERENCES `one` (`ONE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


 */
@Entity
@Table(name = "many")
public class Many implements java.io.Serializable {

	private int manyId;
	private One one;

	public Many() {
	}

	public Many(int manyId, One one) {
		super();
		this.manyId = manyId;
		this.one = one;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MANY_ID", unique = true, nullable = false)
	public int getManyId() {
		return manyId;
	}

	public void setManyId(int manyId) {
		this.manyId = manyId;
	}

	// 以下是重點:
	/*
	 * FetchType是決定取出資料時, 是否將關聯資料放到記憶體
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)時, 取出資料會把關聯資料會放入記憶體
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)時, 它關聯的數據並不取出來，在同一個session中
	 * 什麼時候要用，就什麼時候取(再次訪問數據庫)
	 * 
	 * 但是，在session外，就不能再取了。 用EAGER時，因為在內存裡，所以在session外也可以取。
	 * 一般只在一邊設Eager，JPA接口默認為一對多為Lazy，多對一為Eager
	 * 但是Hibernate反向工程生成Entity時，多對一為Lazy，需要手動改為Eager。
	 * https://my.oschina.net/u/1163293/blog/169456
	 * 
	 * ------ 四種關係: https://my.oschina.net/aiguozhe/blog/232737
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ONE_ID", nullable = false, insertable = false, updatable = false)
	/*
	 * name屬性: 指向一的一方
	 * @JoinColumn(name = "ONE_ID", nullable = false)  <==一對多
	 * @JoinColumn(name = "MANY_ID", nullable = false,
	 *  insertable = false, updatable = false) <==多對一
	 * 在多對一的情況, "一"是不可更新和刪除的(會造成無對應)所以要加
	 * insertable = false, updatable = false屬性
	 */
	public One getOne() { // 對應One的mappedBy
		return one;
	}

	public void setOne(One one) {
		this.one = one;
	}

}
