package co.edu.icesi.ostrich_log.api;

import org.springframework.web.bind.annotation.*;

import co.edu.icesi.ostrich_log.dto.OstrichDTO;

import java.util.List;
import java.util.UUID;

@RequestMapping("/ostrich")
public interface OstrichAPI {

    @PostMapping
    OstrichDTO createOstrich(@RequestBody OstrichDTO ostrichDTO);

    @GetMapping("/{ostrichId}")
    OstrichDTO getOstrich(@PathVariable UUID ostrichId);

    @GetMapping
    List<OstrichDTO> getOstrich();

    @PostMapping("/{documentId}")
    OstrichDTO updateOstrich(@PathVariable UUID ostrichId, @RequestBody OstrichDTO ostrichDTO);
}
