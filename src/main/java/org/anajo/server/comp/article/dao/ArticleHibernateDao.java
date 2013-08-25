package org.anajo.server.comp.article.dao;

import org.anajo.server.comp.article.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleHibernateDao implements ArticleDao {

	@Autowired
	SessionFactory sessionFactory;

	public void insertArticle(Article article) {

	}

	@Override
	public Article getArticles() {
		Session session = sessionFactory.getCurrentSession();
		return (Article) session.get(Article.class, 1);
	}

}