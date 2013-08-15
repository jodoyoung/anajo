package org.anajo.server.util;

public class PageNavigation extends AbstractPageNavigation {

	public PageNavigation() {
		this(10, 10, 1, 0);
	}

	public PageNavigation(int currPage) {
		this(10, 10, currPage);
	}

	public PageNavigation(int rowSize, int currPage) {
		this(rowSize, 10, currPage);
	}

	public PageNavigation(int rowSize, int pageSize, int currPage) {
		this(rowSize, pageSize, currPage, 0);
	}

	public PageNavigation(int rowSize, int pageSize, int currPage, int totalRow) {
		super(rowSize, pageSize, currPage, totalRow);
	}

	@Override
	public String getNavi() {
		StringBuffer str = new StringBuffer();

		str.append("<table width='100%'><tr>");

		if (size() > 0) {
			str.append("<td style='width:20%;text-align:left'>총 <b>");
			str.append(getTotalRow());
			str.append("</b>건</td>");

			str.append("<td style='width:8%;text-align:center'>");
			if (isFirst()) {
				str.append("<a href='javascript:goPage(1);'>처음</a>");
			}
			str.append("</td>");

			str.append("<td style='width:5%;text-align:center'>");
			if (isPrev()) {
				str.append("<a href='javascript:goPage(" + getPrev()
						+ ");'>◀◀</a>");
			}
			str.append("</td>");

			str.append("<td style='width:3%;text-align:center'>");
			if (isFirst()) {
				str.append("<a href='javascript:goPage(" + getPrevPage()
						+ ");'>◀</a>");
			}
			str.append("</td>");

			str.append("<td style='width:38%;text-align:center'>");
			for (int i = getStartPage(); i <= getEndPage(); i++) {
				str.append("&nbsp;<a href='javascript:goPage(" + i + ");'");
				if (i == getCurrPage()) {
					str.append(" style='color: #0066FF;font-weight:bold;'");
				}
				str.append(">" + i + "</a>&nbsp;");
			}
			str.append("</td>");

			str.append("<td style='width:3%;text-align:center'>");
			if (isLast()) {
				str.append("<a href='javascript:goPage(" + getNextPage()
						+ ");' >▶</a>");
			}
			str.append("</td>");

			str.append("<td style='width:5%;text-align:center'>");
			if (isNext()) {
				str.append("<a href='javascript:goPage(" + getNext()
						+ ");' >▶▶</a>");
			}
			str.append("</td>");

			str.append("<td style='width:8%;text-align:center'>");
			if (isLast()) {
				str.append("<a href='javascript:goPage(" + getTotalPage()
						+ ");' >마지막</a>");
			}
			str.append("</td>");

			str.append("<td style='width:15%;text-align:right'><b>"
					+ getCurrPage() + "</b>&nbsp;/&nbsp;" + getTotalPage());
			str.append("</td></tr></table>");
		} else {
			str.append("<table><tr><td>검색결과가 없습니다.</td></tr></table>");
		}
		return str.toString();
	}
}
