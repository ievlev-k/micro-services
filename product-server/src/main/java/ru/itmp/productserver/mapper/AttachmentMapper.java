package ru.itmp.productserver.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.itmp.productserver.dto.request.AttachmentRequest;
import ru.itmp.productserver.dto.responce.AttachmentResponse;
import ru.itmp.productserver.dto.update.AttachmentUpdate;
import ru.itmp.productserver.model.Attachment;


import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AttachmentMapper {
    private final ModelMapper modelMapper;

    public Attachment attachmentUpdateToAttachment(AttachmentUpdate attachmentUpdate) {
        return modelMapper.map(attachmentUpdate, Attachment.class);
    }

    public Attachment attachmentRequestToAttachment(AttachmentRequest request) {
        return modelMapper.map(request, Attachment.class);
    }

    public AttachmentResponse attachmentToAttachmentResponse(Attachment attachment) {
        return modelMapper.map(attachment, AttachmentResponse.class);
    }

    public Page<AttachmentResponse> attachmentToAttachmentResponsePage(Page<Attachment> attachmentPage) {
        return attachmentPage.map(this::attachmentToAttachmentResponse);
    }

    public List<AttachmentResponse> attachmentToAttachmentResponseList(List<Attachment> attachmentList) {
        return attachmentList
                .stream()
                .map(this::attachmentToAttachmentResponse)
                .collect(Collectors.toList());
    }
}
