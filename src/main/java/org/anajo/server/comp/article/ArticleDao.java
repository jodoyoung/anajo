package org.anajo.server.comp.article;

import org.anajo.server.comp.article.model.Article;
import org.springframework.stereotype.Repository;

/**
 * 게시글 데이터 제어
 * 
 * @author jodoyoung
 * 
 */
@Repository
public interface ArticleDao {

	/**
	 * 전체 게시글 조회
	 * 
	 * @return
	 */
	Article selectArticles();
}
