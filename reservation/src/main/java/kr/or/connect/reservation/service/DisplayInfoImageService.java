package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;

public interface DisplayInfoImageService {
	
	public List<DisplayInfoImage> getDisplayInfoImageList();
	public DisplayInfoImage addDisplayInfoImage(DisplayInfoImage displayInfoImage);
	public int deleteDisplayInfoImage(Integer id);
	public DisplayInfoImage selectDisplayInfoImage(Integer id);
	
}
