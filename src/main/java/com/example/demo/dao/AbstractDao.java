package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.entity.Page;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<T> implements BatchDao<T>   {
    protected EntityManager em;

    @Override
    @Transactional
    public void batchUpdate(List<T> list) {
        for (int i=0;i<list.size();i++){
            em.persist(list.get(0));
            if (i%50==0){
                em.flush();
                em.clear();
            }
        }

    }

    @Override
    @Transactional
    public void batchInsert(List<T> list) {
        for (int i=0;i<list.size();i++){
            em.merge(list.get(0));
            if (i%50==0){
                em.flush();
                em.clear();
            }
        }
    }

    public List<T> findPageByQuery(final String queryS, final Object[] parameters, final Page page){

        Session session = (Session) em.getDelegate();
        Query query = session.createQuery(queryS);
        // 判断有无条件参数的情况
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i, parameters[i]);
            }
        }
        // 使用游标来得到总条数
        ScrollableResults sr = query.scroll();
        sr.last();
        int totalCount = sr.getRowNumber();
        int totalRec = totalCount + 1;

        page.setTotalCount(totalRec);

        int startIndex = (page.getPageNum() - 1) * page.getNumPerPage();

        query.setFirstResult(startIndex);
        query.setMaxResults(page.getNumPerPage());
        List reList = query.list();
        return reList;

    }
}
