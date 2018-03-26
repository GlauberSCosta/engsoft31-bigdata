package com.engsoft31.bigdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.engsoft31.bigdata.model.Club;
import com.engsoft31.bigdata.model.Nation;
import com.engsoft31.bigdata.model.Player;
import com.engsoft31.bigdata.service.PlayerService;

@Controller
public class PlayerController {

	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		Player player = new Player();
		player.setName("Cristiano Ronaldo");
		player.setFullName("C. Ronaldo dos Santos Aveiro");
		player.setHeight(185.0D);
		player.setWeight(80.0D);
		player.setOverall(94);
		player.setPreferredFoot("Direito");
		player.setAge(33);
		player.setPhoto("https://cdn.sofifa.org/18/players/20801.png");
		
		Club club = new Club();
		club.setName("Real Madrid CF");
		club.setLogo("https://cdn.sofifa.org/18/teams/243.png");
		
		player.setClub(club);
		
		Nation nation = new Nation();
		nation.setName("Portugal");
		player.setNation(nation);
		
		model.addAttribute("player", player);
		return "index";
	}
}

