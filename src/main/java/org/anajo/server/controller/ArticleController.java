package org.anajo.server.controller;

import java.util.List;

import org.anajo.server.comp.article.service.ArticleServiceImpl;
import org.anajo.server.comp.menu.MenuService;
import org.anajo.server.comp.menu.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleServiceImpl articleService;

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		List<Menu> categories = menuService
				.getMenuList("8ac7dae0157d4bdba763aa01b7ce9222");
		model.addAttribute("categories", categories);
		return "article/home.tiles";
	}

	@RequestMapping(value = "/{category}", method = RequestMethod.GET)
	public String list(@PathVariable String category, Model model) {
		return "article/list.tiles";
	}

	@RequestMapping(value = "/{category}/create", method = RequestMethod.GET)
	public String createView(@PathVariable String category, Model model) {
		return "article/create.tiles";
	}

	@RequestMapping(value = "/{category}/create", method = RequestMethod.POST)
	public String create(@PathVariable String category, Model model) {
		return "article/list.tiles";
	}

	@RequestMapping(value = "/{category}/{number}", method = RequestMethod.GET)
	public String read(@PathVariable String category,
			@PathVariable String number, Model model) {
		return "article/read.tiles";
	}

	@RequestMapping(value = "/{category}/update", method = RequestMethod.GET)
	public String updateView(@PathVariable String category, Model model) {
		return "article/read.tiles";
	}

	@RequestMapping(value = "/{category}/update", method = RequestMethod.POST)
	public String update(@PathVariable String category, Model model) {
		return "article/read.tiles";
	}

	@RequestMapping(value = "/{category}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable String category, Model model) {
		return "article/list.tiles";
	}
}
