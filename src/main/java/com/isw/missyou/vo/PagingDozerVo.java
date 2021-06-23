package com.isw.missyou.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class PagingDozerVo<T, K> extends PagingVO {

  public PagingDozerVo(Page<T> pageT, Class<K> kClass) {
    this.initPageParameters(pageT);
    Mapper mapper = DozerBeanMapperBuilder.buildDefault();
    List<T> tList = pageT.getContent();
    List<K> kList = new ArrayList<>();
    tList.forEach(
        t -> {
          K kVo = mapper.map(t, kClass);
          kList.add(kVo);
        });
    this.setItems(kList);
  }
}
