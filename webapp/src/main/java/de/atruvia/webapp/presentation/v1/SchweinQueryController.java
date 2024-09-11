package de.atruvia.webapp.presentation.v1;


import de.atruvia.webapp.domain.SchweinService;
import de.atruvia.webapp.domain.SchweineServiceException;
import de.atruvia.webapp.domain.model.Schwein;
import de.atruvia.webapp.presentation.dto.PersonDTO;
import de.atruvia.webapp.presentation.dto.SchweinDTO;
import de.atruvia.webapp.presentation.mapper.SchweinDTOMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/schweine")
@RequiredArgsConstructor
public class SchweinQueryController {

    private final SchweinService schweinService;
    private final SchweinDTOMapper schweinDTOMapper;

    @Operation(summary = "Liefert eine Person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person gefunden",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "ungueltige ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Person nicht gefunden",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "internal server error",
                    content = @Content)})

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SchweinDTO> findById(@PathVariable  UUID id) throws SchweineServiceException {
           return ResponseEntity.of(schweinService.findeAnhandId(id).map(schweinDTOMapper::convert));
    }

    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<SchweinDTO>> findById(
            @RequestParam(required = false, defaultValue = "Fritz") String vorname,
            @RequestParam(required = false, defaultValue = "Schmitt") String nachname
    ) throws SchweineServiceException{

        System.out.printf("Vorname = %s und Nachname = %s\n", vorname, nachname);


        return ResponseEntity.ok(schweinDTOMapper.convert(schweinService.findeAlle()));
    }


    @PostMapping(value ="/actions",
            produces = {MediaType.APPLICATION_JSON_VALUE} ,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public PersonDTO toUpper(@RequestParam(required = false, defaultValue = "to-upper") String action, @RequestBody PersonDTO dto) {
        dto.setVorname(dto.getVorname().toUpperCase());
        dto.setNachname(dto.getNachname().toUpperCase());
        return dto;
    }


}
