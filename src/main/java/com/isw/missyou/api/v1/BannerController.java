package com.isw.missyou.api.v1;

import com.isw.missyou.exception.http.NotFoundException;
import com.isw.missyou.model.Banner;
import com.isw.missyou.service.interfaces.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

  @Autowired private BannerService bannerService;

  @GetMapping("/name/{name}")
  public Banner getByName(@PathVariable String name) {
    Banner banner = bannerService.getByName(name);
    if (banner == null) {
      throw new NotFoundException(30005);
    }
    return banner;
  }

  //  主动注入
  //  @Qualifier("camille")
  // Autowired 的被动注入方式 1. byType 2. byName
  // Autowired 的主动注入方式 加上@Qualifier("irelia") 去指定你想要注入的bean的实际类型， 但是一定要面向接口或者抽象编程

}
