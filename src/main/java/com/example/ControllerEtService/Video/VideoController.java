package com.example.ControllerEtService.Video;

import java.util.List;

import com.example.model.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/api/Video")
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Video>> getAllVideos() {
        return new ResponseEntity<List<Video>>(videoService.getAllVideos(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Video> getVideoByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Video video = videoService.findByIdentifiant(id);
            if (video != null) {
                return new ResponseEntity<Video>(video, HttpStatus.OK);
            } else {
                return new ResponseEntity<Video>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<Video>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Video> registerNewVideo(@RequestBody Video video) {
        try {
            Video v = videoService.addNewVideo(video);
            System.out.println(v.getId());
            return new ResponseEntity<Video>(v, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Video>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{identifiant}")
    public ResponseEntity<Video> deleteVideo(@PathVariable(value = "identifiant") Integer id) {
        try {
            videoService.deleteVideo(id);
            return new ResponseEntity<Video>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Video>(HttpStatus.BAD_REQUEST);
        }
    }

}
