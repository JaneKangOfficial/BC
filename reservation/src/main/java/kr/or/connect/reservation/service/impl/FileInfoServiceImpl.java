package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.FileInfoDao;
import kr.or.connect.reservation.dto.FileInfo;
import kr.or.connect.reservation.service.FileInfoService;

@Service
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
	FileInfoDao fileInfoDao;
	
	@Override
	public List<FileInfo> getFileInfoList() {
		System.out.println("FileInfoServiceImpl.java => getFileInfoList");
		List<FileInfo> list = fileInfoDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public FileInfo addFileInfo(FileInfo fileInfo) {
		System.out.println("FileInfoServiceImpl.java => addFileInfo");
		int id = fileInfoDao.insert(fileInfo);
		fileInfo.setId(id);
		return fileInfo;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteFileInfo(Integer id) {
		System.out.println("FileInfoServiceImpl.java => deleteFileInfo");
		int delteFileInfo = fileInfoDao.deleteById(id);
		return delteFileInfo;
	}

	@Override
	public FileInfo selectFileInfo(Integer id) {
		System.out.println("FileInfoServiceImpl.java => selectFileInfo");
		FileInfo selectFileInfo = fileInfoDao.selectById(id);
		return selectFileInfo;
	}


}
