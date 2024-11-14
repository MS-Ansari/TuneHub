package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tunehub.entities.Song;
import com.tunehub.services.SongService;

@ Controller
public class SongsController
{
	@Autowired
	SongService songserv;
	
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song)
	{
		//we can also use this &  create one extra variable
		//String name = song.getName();
		//boolean status = songserv.songExists(name);
		
	boolean status = songserv.songExists(song.getName());	
		
		if (status == false)
		{
			 songserv.addSongs(song);
			 return "songsuccess";
			
		}else
		{
			return "songfail";
		}
		
	}
	@GetMapping("/map-viewsongs")
	public String viewSongs(Model model)
	{
	List<Song> songslist  =	songserv.fetchAllSongs();
	model.addAttribute("songslist", songslist);
	return "displaysongs";
	}
	
	@GetMapping("/viewsongs")
	public String viewCustomerSongs(Model model)
	{
		boolean primeCustomerStatus=true;
		if(primeCustomerStatus == true)
		{
			List<Song> songslist  =	songserv.fetchAllSongs();
			model.addAttribute("songslist", songslist);
			return "displaysongs";
			
		}else
		{
			return"makepayment";
		}
		
	}
	
	
	
	
	
	
	
	

}
