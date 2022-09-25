package co.edu.icesi.ostrich_log.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.ostrich_log.api.OstrichAPI;
import co.edu.icesi.ostrich_log.dto.OstrichDTO;
import co.edu.icesi.ostrich_log.mapper.OstrichMapper;
import co.edu.icesi.ostrich_log.service.OstrichService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class OstrichController implements OstrichAPI {

    private final OstrichMapper ostrichMapper;

    private final OstrichService ostrichService;

    @Override
    public OstrichDTO createOstrich(OstrichDTO ostrichDTO) {
        return ostrichMapper.fromOstrich(ostrichService.createOstrich(ostrichMapper.fromDTO(ostrichDTO)));
    }
    @Override
    public OstrichDTO getOstrich(UUID ostrichId) {
        return ostrichMapper.fromOstrich(ostrichService.getOstrich(ostrichId));
    }

    @Override
    public List<OstrichDTO> getOstrich() {
        return ostrichService.getOstrichs().stream().map(ostrichMapper::fromOstrich).collect(Collectors.toList());
    }

    @Override
    public OstrichDTO updateOstrich(UUID ostrichId, OstrichDTO ostrichDTO) {
        return ostrichMapper.fromOstrich(ostrichService.updateOstrich(ostrichMapper.fromDTO(ostrichId,ostrichDTO)));
    }

}
