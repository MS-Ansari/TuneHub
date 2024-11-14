package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Song;
import com.tunehub.repositories.SongRepository;
@Service
public class SongServiceImplimentation implements SongService
{
	@Autowired
	SongRepository srepo;

	@Override
	public String addSongs(Song song) {
		srepo.save(song);
		return "Song is added.";
	}

	@Override
	public boolean songExists(String name) {
		Song song =srepo.findByName(name);
		if(song == null)
		{
			return false;
		}else
		{
			return true;
		}
		
	}

	@Override
	public List<Song> fetchAllSongs() 
	{
	List <Song> songslist  =	srepo.findAll();
	return songslist;
		
		
	}

}
