package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry newTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        return ResponseEntity.created(null).body(newTimeEntry);
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if (timeEntry == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(timeEntry);
        }
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries = timeEntryRepository.list();
        return ResponseEntity.ok(timeEntries);
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {
        TimeEntry updatedTimeEntry = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
        if (updatedTimeEntry == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedTimeEntry);
        }
    }

    public ResponseEntity<Void> delete(long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }
}
