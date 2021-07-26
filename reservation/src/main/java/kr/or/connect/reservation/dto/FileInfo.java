package kr.or.connect.reservation.dto;

public class FileInfo {

	private int id;
	private String fileName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfileName() {
		return fileName;
	}
	public void setfileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", fileName=" + fileName + "]";
	}
	
}
