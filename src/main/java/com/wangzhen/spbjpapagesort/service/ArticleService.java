package com.wangzhen.spbjpapagesort.service;

import com.wangzhen.spbjpapagesort.bean.Article;
import com.wangzhen.spbjpapagesort.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ArticleService
 * @Description
 * @Author wangzhen
 * @Date 2018/12/9 下午6:44
 **/
@Service
public class ArticleService {

    // 注入数据访问层接口对象
    @Resource
    private ArticleRepository articleRepository;

    public Iterable<Article> findAllSort(Sort sort) {
        return articleRepository.findAll(sort);
    }

    public Page<Article> findAll(Pageable page) {
        return articleRepository.findAll(page);
    }

}
