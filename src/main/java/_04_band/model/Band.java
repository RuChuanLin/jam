package _04_band.model;

import java.sql.Blob;
import java.sql.Clob;


public class Band {
	private int pk;
	private String category;
	private String area;
	private byte style;
	private java.sql.Clob description;
	private byte isGrouped;
	private int videoId;
	private String mateLink;
	private java.sql.Blob image;
	private byte bandStatus;
	public int getPk() {
		return pk;
	}
	public void setPk(int pk) {
		this.pk = pk;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public byte getStyle() {
		return style;
	}
	public void setStyle(byte style) {
		this.style = style;
	}
	public java.sql.Clob getDescription() {
		return description;
	}
	public void setDescription(java.sql.Clob description) {
		this.description = description;
	}
	public byte getIsGrouped() {
		return isGrouped;
	}
	public void setIsGrouped(byte isGrouped) {
		this.isGrouped = isGrouped;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getMateLink() {
		return mateLink;
	}
	public void setMateLink(String mateLink) {
		this.mateLink = mateLink;
	}
	public java.sql.Blob getImage() {
		return image;
	}
	public void setImage(java.sql.Blob image) {
		this.image = image;
	}
	public byte getBandStatus() {
		return bandStatus;
	}
	public void setBandStatus(byte bandStatus) {
		this.bandStatus = bandStatus;
	}
	public Band(String category, String area, byte style, Clob description, byte isGrouped, int videoId,
			String mateLink, Blob image, byte bandStatus) {
		this.category = category;
		this.area = area;
		this.style = style;
		this.description = description;
		this.isGrouped = isGrouped;
		this.videoId = videoId;
		this.mateLink = mateLink;
		this.image = image;
		this.bandStatus = bandStatus;
	}
	public Band(int pk) {
		this.pk = pk;
	}
	public Band() {
	}
	public Band(int pk, String category, String area, byte style, Clob description, byte isGrouped, int videoId,
			String mateLink, Blob image, byte bandStatus) {
		this.pk = pk;
		this.category = category;
		this.area = area;
		this.style = style;
		this.description = description;
		this.isGrouped = isGrouped;
		this.videoId = videoId;
		this.mateLink = mateLink;
		this.image = image;
		this.bandStatus = bandStatus;
	}
}
