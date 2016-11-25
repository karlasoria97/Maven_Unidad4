package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Song;
import boot.service.SongService;

@Controller
public class SongsController {
	
	@Autowired
	private SongService songService;
	
	@GetMapping("/all-songs")
	public String allSongs(HttpServletRequest request){
		request.setAttribute("songs", songService.findAll());
		request.setAttribute("mode", "MODE_SONGS");
		return "songs";
	}
	
	@GetMapping("/new-song")
	public String newSong(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_SONG");
		return "songs";
	}
	
	@PostMapping("/save-song")
	public String saveSong(@ModelAttribute Song song, BindingResult bindingResult, HttpServletRequest request){
		songService.save(song);
		request.setAttribute("songs", songService.findAll());
		request.setAttribute("mode", "MODE_SONGS");
		return "songs";
	}
	
	@GetMapping("/update-song")
	public String updateSong(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("song", songService.findSong(id));
		request.setAttribute("mode", "MODE_UPDATE_SONGS");
		return "songs";
	}
	
	@GetMapping("/delete-song")
	public String deleteSong(@RequestParam int id, HttpServletRequest request){
		songService.delete(id);
		request.setAttribute("songs", songService.findAll());
		request.setAttribute("mode", "MODE_SONGS");
		return "songs";
	}

}
