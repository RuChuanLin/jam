package _04_band.model;

import java.util.Calendar;

public class Band {
	private int bandId;
	private int author;
	private String title;
	private String category;
	private String instruments;
	private String area;
	private String detailedArea;
	private String style;
	private byte isGrouped;
	private String mateLink;
	private String video;
	private String description;
	private String image;
	private Calendar updatetime;
	private byte bandStatus;
	
	public int getBandId() {
		return bandId;
	}
	public void setBandId(int bandId) {
		this.bandId = bandId;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getInstruments() {
		return instruments;
	}
	public void setInstruments(String instruments) {
		this.instruments = instruments;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDetailedArea() {
		return detailedArea;
	}
	public void setDetailedArea(String detailedArea) {
		this.detailedArea = detailedArea;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public byte getIsGrouped() {
		return isGrouped;
	}
	public void setIsGrouped(byte isGrouped) {
		this.isGrouped = isGrouped;
	}
	public String getMateLink() {
		return mateLink;
	}
	public void setMateLink(String mateLink) {
		this.mateLink = mateLink;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public byte getBandStatus() {
		return bandStatus;
	}
	public void setBandStatus(byte bandStatus) {
		this.bandStatus = bandStatus;
	}
	public Calendar getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Calendar updatetime) {
		this.updatetime = updatetime;
	}
	public Band(int author, String title, String category, String instruments, String area, String detailedArea,
			String style, byte isGrouped, String mateLink, String video, String description, String image,
			Calendar updatetime, byte bandStatus) {
		super();
		this.author = author;
		this.title = title;
		this.category = category;
		this.instruments = instruments;
		this.area = area;
		this.detailedArea = detailedArea;
		this.style = style;
		this.isGrouped = isGrouped;
		this.mateLink = mateLink;
		this.video = video;
		this.description = description;
		this.image = image;
		this.bandStatus = bandStatus;
		this.updatetime = updatetime;
	}
	public Band() {
		super();
	}
	
	
	
}
