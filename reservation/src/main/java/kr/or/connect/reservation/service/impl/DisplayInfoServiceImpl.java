package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoDao;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.service.DisplayInfoService;

public class DisplayInfoServiceImpl implements DisplayInfoService{

	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Override
	public List<DisplayInfo> getDisplayInfoList() {
		System.out.println("DisplayInfoServiceImple.java => getDisplayInfoList");
		List<DisplayInfo> list = displayInfoDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public DisplayInfo addDisplayInfo(DisplayInfo displayInfo) {
		System.out.println("DisplayInfoServiceImple.java => addDisplayInfo");
		int id = displayInfoDao.insert(displayInfo);
		displayInfo.setId(id);
		return displayInfo;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteDisplayInfo(Integer id) {
		System.out.println("DisplayInfoServiceImple.java => deleteDisplayInfo");
		int deleteDisplayInfo = displayInfoDao.deleteById(id);
		return deleteDisplayInfo;
	}

	@Override
	public DisplayInfo selectDisplayInfo(Integer id) {
		System.out.println("DisplayInfoServiceImple.java => selectDisplayInfo");
		DisplayInfo selectDisplayInfo = displayInfoDao.selectById(id);
		return selectDisplayInfo;
	}

}
