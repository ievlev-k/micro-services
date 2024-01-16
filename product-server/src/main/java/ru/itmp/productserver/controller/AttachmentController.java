package ru.itmp.productserver.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import ru.itmp.productserver.dto.request.AttachmentRequest;
import ru.itmp.productserver.dto.responce.AttachmentResponse;
import ru.itmp.productserver.dto.update.AttachmentUpdate;
import ru.itmp.productserver.services.AttachmentService;
import ru.itmp.productserver.feign.AuthFeignClient;
import ru.itmp.productserver.mapper.AttachmentMapper;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/attachment")
public class AttachmentController {
    private final AttachmentService attachmentService;
    private final AuthFeignClient authFeign;
    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentController(AttachmentService attachmentService, AuthFeignClient authFeign, AttachmentMapper attachmentMapper) {
        this.attachmentService = attachmentService;
        this.authFeign = authFeign;
        this.attachmentMapper = attachmentMapper;
    }

    @GetMapping("/test")
    public String test() {
        return "test2";
    }

    @PostMapping
    public ResponseEntity<AttachmentResponse> addAttachment(@RequestBody AttachmentRequest attachmentRequest, @RequestHeader("Authorization") String token) {
        System.out.println("token: " + token);
        
        // if (!authFeign.checkAdminPermission(token)) {
        //     System.out.println("checkAdminPermission: false");
        //     return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        // }
        System.out.println("checkAdminPermission: true");
        return new ResponseEntity<>(attachmentService.save(attachmentRequest), HttpStatus.CREATED);
    }

    // @GetMapping
    // @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    // public Page<AttachmentResponse> getListAttachment(@PageableDefault(size = 5) Pageable pageable) {
    //     return attachmentService.getAllPage(pageable);
    // }

    // @GetMapping("/all")
    // @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    // public List<AttachmentResponse> getAllAttachment() {
    //     return attachmentService.getAllList();
    // }

    // @PutMapping
    // @PreAuthorize("hasAnyAuthority('ADMIN')")
    // public AttachmentResponse updateAttachment(@Valid @RequestBody AttachmentUpdate attachmentUpdate) {
    //     return attachmentService.update(attachmentUpdate);
    // }

    // @GetMapping("/{id}")
    // @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    // public AttachmentResponse getAttachmentDetail(@PathVariable Long id) {
    //     return attachmentService.findAttachmentById(id);
    // }

    // @DeleteMapping("/{id}")
    // @PreAuthorize("hasAnyAuthority('ADMIN')")
    // public void deleteAttachment(@PathVariable Long id) {
    //     attachmentService.deleteById(id);
    // }

}