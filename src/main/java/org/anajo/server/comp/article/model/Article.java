package org.anajo.server.comp.article.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 게시글
 * 
 * @author jodoyoung
 * @date 2012. 7. 13.
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 7391924489928215080L;

	/** UID */
	private String articleId;

	/** 제목 */
	private String title;

	/** 본문 */
	private String content;

	/** 등록일시 */
	private Calendar regDate;

	/** 첨부파일 */
	private List<String> files;

	public Article() {
	}

	@Id
	@Column(name = "article_id")
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "reg_date")
	public Calendar getRegDate() {
		return regDate;
	}

	public void setRegDate(Calendar regDate) {
		this.regDate = regDate;
	}

	@Transient
	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((articleId == null) ? 0 : articleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}

}
