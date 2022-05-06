package com.example.ControllerEtService.Video;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.model.Video;
import com.example.repository.VideoRepository;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video findByIdentifiant(Integer id) {
        return videoRepository.findByIdentifiant(id);
    }

    public Video addNewVideo(Video video) {
        return videoRepository.save(video);
    }

    public void deleteVideo(Integer id) {
        Video video = videoRepository.findByIdentifiant(id);
        if (video != null) {
            videoRepository.delete(video);
        } else {
            throw new Error("Video doesn't exist");
        }
    }
}
