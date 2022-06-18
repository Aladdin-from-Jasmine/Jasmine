package com.ssg.Jasmine.controller.auction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.ssg.Jasmine.controller.user.UserSession;
import com.ssg.Jasmine.domain.Auction;
import com.ssg.Jasmine.domain.Bid;
import com.ssg.Jasmine.domain.SuccessBidder;
import com.ssg.Jasmine.domain.User;
import com.ssg.Jasmine.service.AuctionService;
import com.ssg.Jasmine.service.BidService;
import com.ssg.Jasmine.service.SuccessBidderService;
import com.ssg.Jasmine.service.UserService;


@Controller
@SessionAttributes("auctionForm")
@RequestMapping("/auction/*")
public class AuctionFormController implements ApplicationContextAware  {
	
	private static final String AUCTION_FORM = "auction/auction_form";
	private static final String AUCTION_DETAIL = "auction/auction_detail";

	@Value("/images/")
	private String uploadDirLocal;
	private WebApplicationContext context;	
	private String uploadDir;

	@Autowired
	private AuctionService auctionService;
	@Autowired
	UserService userService;
	@Autowired
	BidService bidService;

	@Override				
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath(this.uploadDirLocal);
		System.out.println(this.uploadDir);
	}

	@ModelAttribute("auctionForm")
	public AuctionForm formBacking(HttpServletRequest request, Model model, SessionStatus sessionStatus) throws Exception{
		String reqPage = request.getServletPath();
		System.out.println(reqPage);
		String auctionId = request.getParameter("auctionId");
		if(auctionId == null) { 
			return new AuctionForm();
		} else { 
			Auction auction = auctionService.getAuction(Integer.valueOf(auctionId));
			System.out.println("수정 전 auction 객체: " + auction.toString());
			return new AuctionForm(auction);
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showAuctionForm(@ModelAttribute("auctionForm") AuctionForm auctionForm) {
		return AUCTION_FORM;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpServletRequest request, @Valid @ModelAttribute("auctionForm") AuctionForm auctionForm, BindingResult result,
			Model model, SessionStatus sessionStatus, HttpSession session) {
		System.out.println(auctionForm.toString());

		Auction auction = auctionForm.getAuction();
		
		String reqPage = request.getServletPath();
		String requestUrl = reqPage.trim();
		
		MultipartFile report = auction.getReport();
		String filename = uploadFile(report);
		model.addAttribute("fileUrl", this.uploadDirLocal + filename);

		//대표 이미지 선택 안 했을 시
		if (report.getSize() == 0) {
			result.rejectValue("auction.report", "notSelected");
		}

		if (result.hasErrors()) {
			if (requestUrl.equals("/auction/update")) {
				model.addAttribute("auctionId", auction.getAuctionId());
				return AUCTION_FORM;
			} else {
				return AUCTION_FORM;
			}
		}
		
		UserSession user  = (UserSession)request.getSession().getAttribute("userSession");

		auction.timeSet();

		if (requestUrl.equals("/auction/update")) { // update
			Auction oldAuction = auctionService.getAuction(auction.getAuctionId());
			String[] oldFileName = oldAuction.getImg().split("/");
			if (deleteFile(uploadDir + oldFileName[2])) {
				System.out.println("파일 삭제 성공! 이제부터 파일 업로드.");
			}
			String savedFileName = uploadFile(auction.getReport());
			auction.setImg(this.uploadDirLocal + filename);
			
			System.out.println(auction.toString());
			auction.setState("proceeding");
			int auctionId = auctionService.updateAuction(auction);
			model.addAttribute("auction", auctionService.getAuction(auctionId));
			
		} else { 
			String savedFileName = uploadFile(auction.getReport());
			auction.setImg(this.uploadDirLocal + filename);

			auction.initAuction(user.getUser());
			System.out.println("[AuctionFormController] auctionForm 값: " + auctionForm.toString());
			auctionService.createAuction(auction);
			model.addAttribute("auction", auction);
		}
		

		session.setAttribute("bidForm", new BidForm());
		
		if(user.getUser().getUserId().equals("admin")) {
			model.addAttribute("isManager", true);
			model.addAttribute("isWriter", false);
			
			System.out.println("user.userid== "+ user.getUser().getUserId());
			System.out.println("auction.getUserId== "+auction.getUserId());
		}
		else {
			model.addAttribute("isWriter", true);
		}
		
		model.addAttribute("date_maxBid", "");
		model.addAttribute("user_maxBid", "아직 입찰자가 없습니다.");
		model.addAttribute("writer", user.getUser().getUsername());
		model.addAttribute("bidForm", session.getAttribute("bidForm"));
		sessionStatus.setComplete();
		return AUCTION_DETAIL;
	}
	
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}
	
	private String uploadFile(MultipartFile report) {
		String filename = UUID.randomUUID().toString() 
						+ "_" + report.getOriginalFilename();
		File file = new File(this.uploadDir + filename);
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	
	private boolean deleteFile(String oldFileSavedName) {

		boolean result = new File(oldFileSavedName).delete();
		return result;
	}
	
	@ModelAttribute("hourData")
	protected List<Hour> referenceData1() throws Exception {
		List<Hour> hour = new ArrayList<Hour>();
		for (int i = 1; i <= 12; i++) {
			hour.add(new Hour(i, i+"시"));			
		}
		return hour;
	}
	
	@ModelAttribute("minuteData")
	protected List<Minute> referenceData2() throws Exception {
		List<Minute> minute = new ArrayList<Minute>();
		minute.add(new Minute(00, "00분"));
		minute.add(new Minute(10, "10분"));
		minute.add(new Minute(20, "20분"));
		minute.add(new Minute(30, "30분"));
		minute.add(new Minute(40, "40분"));
		minute.add(new Minute(50, "50분"));
		return minute;
	}
	
	@ModelAttribute("amPm")
	protected List<String> referenceData3() throws Exception {
		List<String> amPm = new ArrayList<String>();
		amPm.add("am");
		amPm.add("pm");
		return amPm;
	}
}
