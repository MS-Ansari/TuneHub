package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tunehub.entities.PlayList;
import com.tunehub.entities.Song;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PlayListController
{
	@ Autowired
	PlayListService pserv;
	@Autowired
	SongService sserv;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model)
	
	{
		//Fetching the songs using song service
			List <Song>	songlist =	sserv.fetchAllSongs();

			// Adding the songs in the model
			model.addAttribute("songlist", songlist);
			
		// sending createplaylist
		return"createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		
		
		return "playlistsuccess";
	}
	

}
