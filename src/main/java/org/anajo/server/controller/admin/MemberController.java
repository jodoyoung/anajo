package org.anajo.server.controller.admin;

import java.util.Map;

import org.anajo.server.comp.member.MemberService;
import org.anajo.server.comp.member.model.Member;
import org.anajo.server.comp.member.model.MemberEnabledType;
import org.anajo.server.util.EncriptUtil;
import org.anajo.server.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 회원 제어
 * 
 * @author jodoyoung
 * 
 */
@Controller
@RequestMapping("/admin/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	/**
	 * 회원 목록
	 * 
	 * @param searchValues
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String memberList(@RequestParam Map<String, Object> searchValues,
			Model model) {
		model.addAttribute("members", memberService.getMemberList(searchValues));
		return "admin/member/list.admin";
	}

	/**
	 * 회원 보기
	 * 
	 * @param memberId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/read")
	public String member(@RequestParam String memberId, Model model) {
		model.addAttribute("member", memberService.getMember(memberId));
		return "admin/member/read.admin";
	}

	/**
	 * 회원 작성 페이지로 이동
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String writeCreateMember(Model model) {
		model.addAttribute("memberId", IdGenerator.createUUID());
		model.addAttribute("enabledType", MemberEnabledType.values());
		return "admin/member/create.admin";
	}

	/**
	 * 회원 등록
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createMember(@ModelAttribute Member member) {
		memberService.createMember(member);
		return "redirect:/admin/member";
	}

	/**
	 * 회원 수정 페이지로 이동
	 * 
	 * @param memberId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String writeUpdateMember(@RequestParam String memberId, Model model) {
		model.addAttribute("member", memberService.getMember(memberId));
		model.addAttribute("enabledType", MemberEnabledType.values());
		return "admin/member/update.admin";
	}

	/**
	 * 회원 수정
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMember(@ModelAttribute Member member) {
		member.setPassword(EncriptUtil.encriptMD5(member.getPassword(), true));
		memberService.updateMember(member);
		return "redirect:/admin/member";
	}

	/**
	 * 회원 삭제
	 * 
	 * @param memberId
	 * @return
	 */
	public String deleteMember(@RequestParam String memberId) {
		memberService.deleteMember(memberId);
		return "redirect:/admin/member";
	}

}
