package org.anajo.server.comp.article.service;

import org.anajo.server.comp.article.dao.ArticleHibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl {

	@Autowired
	private ArticleHibernateDao dao;

	public void getArticles() {
		dao.getArticles();
	}
	
}
