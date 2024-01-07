package ru.itmp.productserver.services;

import ru.itmp.productserver.dto.request.AttachmentRequest;
import ru.itmp.productserver.dto.responce.AttachmentResponse;
import org.springframework.data.domain.Page;
import ru.itmp.productserver.dto.update.AttachmentUpdate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AttachmentService {
    AttachmentResponse save(AttachmentRequest attachmentRequest);

    Page<AttachmentResponse> getAllPage(Pageable pageable);

    List<AttachmentResponse> getAllList();

    AttachmentResponse update(AttachmentUpdate attachmentUpdate);

    AttachmentResponse findAttachmentById(Long id);

    void deleteById(Long id);

}
