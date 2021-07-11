package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfo;

public interface DisplayInfoService {

	public List<DisplayInfo> getDisplayInfoList();
	public DisplayInfo addDisplayInfo(DisplayInfo displayInfo);
	public int deleteDisplayInfo(Integer id);
	public DisplayInfo selectDisplayInfo(Integer id);
}
