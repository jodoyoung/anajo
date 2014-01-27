package org.anajo.server.comp.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl {

	@Autowired
	private ArticleDao dao;

	public void getArticles() {
		dao.selectArticles();
	}
	
}
