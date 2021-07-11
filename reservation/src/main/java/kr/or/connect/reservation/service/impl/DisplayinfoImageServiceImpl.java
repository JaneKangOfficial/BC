package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.DisplayInfoImageDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.service.DisplayInfoImageService;

@Service
public class DisplayinfoImageServiceImpl implements DisplayInfoImageService {

	@Autowired
	DisplayInfoImageDao displayInfoImageDao;

	@Override
	public List<DisplayInfoImage> getDisplayInfoImageList() {
		System.out.println("DisplayInfoImageServiceImpl.java => getDisplayInfoImageList");
		List<DisplayInfoImage> list = displayInfoImageDao.selectAll();
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public DisplayInfoImage addDisplayInfoImage(DisplayInfoImage displayInfoImage) {
		System.out.println("DisplayInfoImageServiceImpl.java => addDisplayInfoImage");
		int id = displayInfoImageDao.insert(displayInfoImage);
		displayInfoImage.setId(id);
		return displayInfoImage;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteDisplayInfoImage(Integer id) {
		System.out.println("DisplayInfoImageServiceImpl.java => deleteDisplayInfoImage");
		int deleteDisplayInfoImage = displayInfoImageDao.deleteById(id);
		return deleteDisplayInfoImage;
	}

	@Override
	public DisplayInfoImage selectDisplayInfoImage(Integer id) {
		System.out.println("DisplayInfoImageServiceImpl.java => selectDisplayInfoImage");
		DisplayInfoImage selectDisplayInfoImage = displayInfoImageDao.selectById(id);
		return selectDisplayInfoImage;
	}

}
