package org.anajo.server.comp.article;

import java.util.List;
import java.util.Map;

import org.anajo.server.comp.article.model.Article;

/**
 * 게시글 서비스
 * 
 * @author jodoyoung
 * @date 2012. 7. 13.
 */
public interface ArticleService {

	/**
	 * 게시글 목록 조회
	 * 
	 * @param searchValues
	 * @return article list
	 */
	List<Article> getArticleList(Map<String, String> searchValues);

	/**
	 * 게시글 조회
	 * 
	 * @param articleId
	 * @return
	 */
	Article getArticle(String articleId);

	/**
	 * 게시글 등록
	 * 
	 * @param article
	 */
	void insertArticle(Article article);

	/**
	 * 게시글 수정
	 * 
	 * @param article
	 */
	void updateArticle(Article article);
}
