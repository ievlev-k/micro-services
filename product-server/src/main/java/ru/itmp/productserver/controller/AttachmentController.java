package ru.itmp.productserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
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
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/attachment")
public class AttachmentController {
    private final AttachmentService attachmentService;
    private final AuthFeignClient authFeign;
    private final AttachmentMapper attachmentMapper;
	private final CircuitBreaker circuitBreaker;

    @GetMapping("/test")
    public String test() {
        return "test2";
    }
    
    @PostMapping
    public ResponseEntity<AttachmentResponse> addAttachment(@RequestBody AttachmentRequest attachmentRequest, @RequestHeader("Authorization") String token) {        
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(attachmentService.save(attachmentRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AttachmentResponse>> getListAttachment(@PageableDefault(size = 5) Pageable pageable) {
        
        return ResponseEntity.ok(attachmentService.getAllPage(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AttachmentResponse>> getAllAttachment() {
        return ResponseEntity.ok(attachmentService.getAllList());
    }

    @PutMapping
    public ResponseEntity<AttachmentResponse> updateAttachment(@RequestBody AttachmentUpdate attachmentUpdate, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return new ResponseEntity<>(attachmentService.update(attachmentUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentResponse> getAttachmentDetail(@PathVariable Long id) {
        return ResponseEntity.ok(attachmentService.findAttachmentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttachment(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        boolean isAdmin = false;
        try {
            isAdmin = circuitBreaker.decorateSupplier(() -> authFeign.checkAdminPermission(token)).get();
        } catch(Exception e) {
            System.out.println("Error:" + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        if (!isAdmin) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        attachmentService.deleteById(id);
        return ResponseEntity.ok("Attachment deleted successfully");
    }

}