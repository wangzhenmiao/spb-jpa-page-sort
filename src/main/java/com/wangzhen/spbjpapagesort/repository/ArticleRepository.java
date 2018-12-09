package com.wangzhen.spbjpapagesort.repository;

import com.wangzhen.spbjpapagesort.bean.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName ArticleRepository
 * @Description
 * @Author wangzhen
 * @Date 2018/12/9 下午6:42
 **/
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}
