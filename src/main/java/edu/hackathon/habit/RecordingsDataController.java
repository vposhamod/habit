package edu.hackathon.habit;

import edu.hackathon.habit.db.Recording;
import edu.hackathon.habit.db.RecordingDbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/recording")
public class RecordingsDataController {

    @Autowired
    RecordingDbUtil recordingsRepository;

    @PostMapping
    public Recording createRecording(@RequestBody Recording recording) {
        recording = recordingsRepository.save(recording);
        return recording;
    }

    @GetMapping
    public List<Recording> listRecordingsIds() {
        List<Recording> allRecords = recordingsRepository.findAll();
        allRecords.forEach(x -> x.setRecording(null));
        return allRecords;
    }

    @PutMapping("/{recordingId}")
    public Recording updateRecording(@RequestBody Recording recording, @PathVariable String recordingId) {
        recording.setRecordingId(recordingId);
        recording = recordingsRepository.save(recording);
        return recording;
    }

    @DeleteMapping("/{recordingId}")
    public String deleteRecording(@PathVariable String recordingId) {
        recordingsRepository.deleteById(recordingId);
        return recordingId;
    }
}
