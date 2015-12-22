package cn.edu.xmu.oneonezero.service;

import java.util.List;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;

public interface CustomizedArtworkService {
	public List<CustomizedArtwork> getAllFinishedCustomizedArtworks();//获取所有定制艺术品成品

	public List<CustomizedArtwork> getAllCustomizedArtworks();//获取所有定制艺术品
}
