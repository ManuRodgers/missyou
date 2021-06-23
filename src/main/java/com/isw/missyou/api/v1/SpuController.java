package com.isw.missyou.api.v1;

import com.isw.missyou.bo.PageCounter;
import com.isw.missyou.exception.http.NotFoundException;
import com.isw.missyou.model.Spu;
import com.isw.missyou.service.interfaces.SpuService;
import com.isw.missyou.util.CommonUtil;
import com.isw.missyou.vo.PagingDozerVo;
import com.isw.missyou.vo.SpuSimplifyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/spu")
@Validated
@Slf4j
public class SpuController {

  @Autowired private SpuService spuService;

  @GetMapping("/id/{id}/detail")
  public Spu getByName(@PathVariable @Positive Long id) {
    log.info("id={}", id);
    Spu spu = spuService.getSpuById(id);
    if (spu == null) {
      throw new NotFoundException(30003);
    }
    return spu;
  }

  @GetMapping("/id/{id}/simplify")
  public SpuSimplifyVO getSimplifySpu(@PathVariable @Positive Long id) {
    Spu spu = this.spuService.getSpuById(id);
    if (spu == null) {
      throw new NotFoundException(30003);
    }
    SpuSimplifyVO spuSimplifyVO = new SpuSimplifyVO();
    BeanUtils.copyProperties(spu, spuSimplifyVO);
    return spuSimplifyVO;
  }

  //  @GetMapping("/latest")
  //  public List<SpuSimplifyVO> getLatestSpuList() {
  //    Mapper mapper = DozerBeanMapperBuilder.buildDefault();
  //    Page<Spu> latestPagingSpu = this.spuService.getLatestPagingSpu(1, 10);
  //    List<Spu> spuList = latestPagingSpu.getContent();
  //    log.info("spuList={}", spuList);
  //    List<SpuSimplifyVO> vos = new ArrayList<>();
  //    spuList.forEach(
  //        spu -> {
  //          SpuSimplifyVO vo = mapper.map(spu, SpuSimplifyVO.class);
  //          vos.add(vo);
  //        });
  //    return vos;
  //  }

  @GetMapping("/latest")
  public PagingDozerVo<Spu, SpuSimplifyVO> getLatestSpuList(
      @RequestParam(defaultValue = "0") Integer start,
      @RequestParam(defaultValue = "10") Integer count) {
    PageCounter pageCounter = CommonUtil.convertToPageParameters(start, count);
    Integer pageNum = pageCounter.getPageNum();
    Integer pageSize = pageCounter.getPageSize();
    Page<Spu> pagingSpu = spuService.getLatestPagingSpu(pageNum, pageSize);
    return new PagingDozerVo<>(pagingSpu, SpuSimplifyVO.class);
  }

  @GetMapping("by/category/{categoryId}")
  public PagingDozerVo<Spu, SpuSimplifyVO> getByCategoryId(
      @PathVariable @Positive(message = "{id.positive}") Long categoryId,
      @RequestParam(name = "is_root", defaultValue = "false") Boolean isRoot,
      @RequestParam(defaultValue = "0") Integer start,
      @RequestParam(defaultValue = "10") Integer count) {
    PageCounter pageCounter = CommonUtil.convertToPageParameters(start, count);
    Page<Spu> pagingSpu =
        spuService.getByCategory(
            categoryId, isRoot, pageCounter.getPageNum(), pageCounter.getPageSize());
    return new PagingDozerVo<>(pagingSpu, SpuSimplifyVO.class);
  }

  //  主动注入
  //  @Qualifier("camille")
  // Autowired 的被动注入方式 1. byType 2. byName
  // Autowired 的主动注入方式 加上@Qualifier("irelia") 去指定你想要注入的bean的实际类型， 但是一定要面向接口或者抽象编程

}
