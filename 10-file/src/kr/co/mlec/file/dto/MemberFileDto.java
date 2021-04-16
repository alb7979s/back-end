package kr.co.mlec.file.dto;

public class MemberFileDto extends FileDto {
	private String id;
	private int fileSeqNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFileSeqNo() {
		return fileSeqNo;
	}
	public void setFileSeqNo(int fileSeqNo) {
		this.fileSeqNo = fileSeqNo;
	}
}