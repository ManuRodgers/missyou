package com.isw.missyou.service;

import com.isw.missyou.model.Banner;
import com.isw.missyou.repository.BannerRepository;
import com.isw.missyou.service.interfaces.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {
  @Autowired private BannerRepository bannerRepository;

  @Override
  public Banner getByName(String name) {
    return bannerRepository.findOneByName(name);
  }
}
