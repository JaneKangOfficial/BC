package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.FileInfo;


public interface FileInfoService {

	public List<FileInfo> getFileInfoList();
	public FileInfo addFileInfo(FileInfo fileInfo);
	public int deleteFileInfo(Integer id);
	public FileInfo selectFileInfo(Integer id);
}
