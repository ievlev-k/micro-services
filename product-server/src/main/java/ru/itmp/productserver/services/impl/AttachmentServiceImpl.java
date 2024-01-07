package ru.itmp.productserver.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itmp.productserver.dto.request.AttachmentRequest;
import ru.itmp.productserver.dto.responce.AttachmentResponse;
import ru.itmp.productserver.dto.update.AttachmentUpdate;
import ru.itmp.productserver.exeptions.ObjectNotFoundException;
import ru.itmp.productserver.mapper.AttachmentMapper;
import ru.itmp.productserver.model.Attachment;
import ru.itmp.productserver.repository.AttachmentRepository;
import ru.itmp.productserver.services.AttachmentService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    @Override
    public AttachmentResponse save(AttachmentRequest attachmentRequest) {
        Attachment attachment = attachmentMapper.attachmentRequestToAttachment(attachmentRequest);
        return attachmentMapper.attachmentToAttachmentResponse(attachmentRepository.save(attachment));
    }

    @Override
    public Page<AttachmentResponse> getAllPage(Pageable pageable) {
        return attachmentMapper.attachmentToAttachmentResponsePage(attachmentRepository.findAll(pageable));
    }

    @Override
    public List<AttachmentResponse> getAllList() {

        return attachmentMapper.attachmentToAttachmentResponseList(attachmentRepository.findAll());
    }

    @Override
    public AttachmentResponse update(AttachmentUpdate attachmentUpdate) {
        Attachment attachment = attachmentMapper.attachmentUpdateToAttachment(attachmentUpdate);
        return attachmentMapper.attachmentToAttachmentResponse(attachmentRepository.save(attachment));
    }

    @Override
    public AttachmentResponse findAttachmentById(Long id) {
        return attachmentMapper.attachmentToAttachmentResponse(attachmentRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Attachment with id " + id + " not found"))
        );
    }

    @Override
    public void deleteById(Long id) {
        attachmentRepository.deleteById(id);
    }


}
