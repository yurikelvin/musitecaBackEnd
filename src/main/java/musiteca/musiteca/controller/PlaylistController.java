package musiteca.musiteca.controller;

import musiteca.musiteca.model.Playlist;
import musiteca.musiteca.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @RequestMapping(value="usuarios/u/{name}/playlists",method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Playlist>> getPlaylists(@PathVariable String name) {
        return new ResponseEntity<>(playlistService.getPlaylistsUsuario(name), HttpStatus.OK);
    }

    @RequestMapping(value="usuarios/u/{name}/playlists",method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Playlist> cadastraPlaylist(@PathVariable String name, @RequestBody Playlist playlist) {
        playlist.setUsuario(name);
        Playlist playlistCadastrada = playlistService.create(playlist);
        return new ResponseEntity<>(playlistCadastrada, HttpStatus.OK);
    }


}
