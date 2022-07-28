package com.bankapp.Bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.Bank.entity.BankAc;
import com.bankapp.Bank.services.BankService;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping({"/","signin"})
public class MyController {
	
	@Autowired
	private BankService t;
	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String sayhsioo() {
			return "home";
	}
	@RequestMapping(value="/xyz",method=RequestMethod.GET)
	public String sayhi() {
			return "signin";
	}
	

	@RequestMapping(value="/show")
	public String sayhi(HttpServletRequest req,ModelMap map) {
		String uName= req.getParameter("uname");
		BankAc b = t.getBankAc(Integer.parseInt(uName));
		Integer amt =b.getBalance();
		System.out.print(amt);
		//map.addAttribute("name",uName);
		map.addAttribute("bal",amt.toString());
		return "show";
	}
	
	
	// withdraw
	@RequestMapping(value="/withdraw",method=RequestMethod.GET)
	public String withdraw() {
			return "withdraw";
	}

	@RequestMapping(value="/showwithdraw")
	public String sa(HttpServletRequest req,ModelMap map) {
		String uName= req.getParameter("uname");
		String amt= req.getParameter("amt");
		t.withdrawalAc(Integer.parseInt(uName),Integer.parseInt(amt));
		BankAc b = t.getBankAc(Integer.parseInt(uName));
		Integer amt1 =b.getBalance();
		System.out.print(amt1);
		//map.addAttribute("name",uName);
		map.addAttribute("bal",amt1.toString());
		return "showwithdraw";
	}
	

	// deposit
	@RequestMapping(value="/deposit",method=RequestMethod.GET)
	public String deposit() {
			return "deposit";
	}

	@RequestMapping(value="/showdeposit")
	public String depositamt(HttpServletRequest req,ModelMap map) {
		String uName= req.getParameter("uname");
		String amt= req.getParameter("amt");
		t.depositAc(Integer.parseInt(uName),Integer.parseInt(amt));
		BankAc b = t.getBankAc(Integer.parseInt(uName));
		Integer amt1 =b.getBalance();
		System.out.print(amt1);
		//map.addAttribute("name",uName);
		map.addAttribute("bal",amt1.toString());
		return "showdeposit";
	}
	@RequestMapping(value="/login")
	public String home(HttpServletRequest req,ModelMap map) {
		String uName= req.getParameter("uname");
		System.out.print(uName);
		int accNo = Integer.parseInt(req.getParameter("uname"));
		System.out.print(t.balCheck(accNo));
		//ModelAndView mav = new ModelAndView("allaccount");
		//mav.addObject("list",t.getListBankAc(accNo));
		//mav.addObject("list",t.getBankAc(accNo));
		//return mav;
		int pwd =  Integer.parseInt(req.getParameter("pwd"));
		String status = req.getParameter("type");
//		BankAc b= new BankAc();
//		b.setAcctId(accNo);
//		b.setAcctStatus(status);
//		b.setBalance(pwd);
//		t.addAc(b);

		map.addAttribute("accId",accNo);

		map.addAttribute("balance",pwd);

	//	map.addAttribute("accNo",accNo);
		//ModelAndView mav =new ModelAndView("show");
		//mav.addObject("u",uName);
		//return "failure";
		//if(uName.equals("john") && pwd.equals("123"))	return "home";
		 //return uName;
		return "singleaccount";
	}
	
	@RequestMapping(value= {"/alllist","/allaccount"})
	public ModelAndView showAllAc() {
		ModelAndView mav = new ModelAndView("allaccount");
		mav.addObject("list",t.getListBankAc());
		return mav;
	}
	
//	@GetMapping("/account")
//	public List<BankAc> getListBankAc(){
//		return this.t.getListBankAc();
//	}
	
//	@RequestMapping(value="/user",method=RequestMethod.GET)
//	public String single(Model mp) {
//		int accNo;
//		mp.addAttribute("e",accNo);
//		return "singleinput";
//	}
	@RequestMapping("/account/{id}")
	public ModelAndView gtAc(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("singleaccount");
		mav.addObject("single",t.getBankAc(id));
		return mav;
	}
//	@RequestMapping("/singleinput")
//	public ModelAndView wdr(@ModelAttribute("e")  int e) {
//		int accNo = e.getAcctId();
//		//int accNo= Integer.parseInt(req.getParameter("uname"));
//		//System.out.println(req.getParameter("uname"));
//		//String pwd = req.getParameter("pwd");
//		//int amt = Integer.parseInt(req.getParameter("amt"));
//		ModelAndView mav = new ModelAndView("singleaccount");
//		mav.addObject("single",t.getBankAc(accNo));
//		return mav;
//		
//	}
//	@GetMapping("/accounts/{accNo}")
//	public BankAc getAc(@PathVariable int accNo){
//		return this.t.getBankAc(accNo);
//	}
	@RequestMapping(value="/account/withdraw",method=RequestMethod.GET)
	public String wdrpge() {
		return "wdrpage1";
	}
	@RequestMapping("/wdrpage1")
	public ModelAndView wdrpagefinal(HttpServletRequest req) {
		int accNo= Integer.parseInt(req.getParameter("uname"));
		String pwd = req.getParameter("pwd");
		int amt = Integer.parseInt(req.getParameter("amt"));
		ModelAndView mav = new ModelAndView("wdrpagefinal");
		
		mav.addObject("final",t.withdrawalAc(accNo,amt));
		return mav;
	}
	@PostMapping("/account")
	public void addBankAc(@RequestBody BankAc b) {
		 this.t.addAc(b);
	}
	@GetMapping("/account/{accNo}/balance")
	public int balanceCheck(@PathVariable int accNo) {
		
		return this.t.balCheck(accNo);
	}
	
	@PutMapping("/account/{accNo}/withdraw/{amt}")
	public void wdrs(@PathVariable int accNo,@PathVariable int amt) {
		this.t.withdrawalAc(accNo,amt);
	}
	@PutMapping("/account/{accNo}/deposit/{amt}")
	public void deposit(@PathVariable int accNo,@PathVariable int amt) {
		this.t.depositAc(accNo,amt);
	}
	// opening an account --create
	// check balance --search  --done
	// withdrawals --update
	// deposit     --update
	
}
