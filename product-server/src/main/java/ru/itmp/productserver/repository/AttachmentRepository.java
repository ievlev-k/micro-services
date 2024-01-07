package ru.itmp.productserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itmp.productserver.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
