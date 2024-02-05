//NoticesController.java
package learn.authorization.controller;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.authorization.model.Notice;
import learn.authorization.repository.NoticeRepository;

@RestController
public class NoticesController {

    private NoticeRepository noticeRepository;

    public NoticesController(NoticeRepository noticeRepository){
        this.noticeRepository=noticeRepository;
    }
    
    // Endpoint to retrieve active notices
    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        // Fetching all active notices from the repository
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices != null ) {
            // Responding with the list of notices and setting cache control to 60 seconds
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            // Returning null if no notices are found
            return null;
        }
    }

}