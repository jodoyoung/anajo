package org.anajo.server.comp.article.dao;

import org.anajo.server.comp.article.model.Article;

/**
 * 게시글 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
public interface ArticleDao {

	/**
	 * 전체 게시글 조회
	 * 
	 * @return
	 */
	Article getArticles();
}
