package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.itmp.productserver.dto.request.AttachmentRequest;
import ru.itmp.productserver.dto.responce.AttachmentResponse;
import ru.itmp.productserver.dto.update.AttachmentUpdate;
import ru.itmp.productserver.services.AttachmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/attachment")
public class AttachmentController {
    private final AttachmentService attachmentService;

    @GetMapping("/test")
    public String test() {
        return "test2";
    }

    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AttachmentResponse addAttachment(@Valid @RequestBody AttachmentRequest attachmentRequest) {
        return attachmentService.save(attachmentRequest);
    }

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Page<AttachmentResponse> getListAttachment(@PageableDefault(size = 5) Pageable pageable) {
        return attachmentService.getAllPage(pageable);
    }

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<AttachmentResponse> getAllAttachment() {
        return attachmentService.getAllList();
    }

    @PutMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public AttachmentResponse updateAttachment(@Valid @RequestBody AttachmentUpdate attachmentUpdate) {
        return attachmentService.update(attachmentUpdate);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public AttachmentResponse getAttachmentDetail(@PathVariable Long id) {
        return attachmentService.findAttachmentById(id);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteById(id);
    }

}