package org.kyawhlaing.apachepoi.excel;

import lombok.RequiredArgsConstructor;
import org.kyawhlaing.apachepoi.constants.ResponseConstants;
import org.kyawhlaing.apachepoi.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReportController {
    private final IReportService iReportService;

    @GetMapping("/insert")
    public ResponseEntity<ResponseDto> insertToDatabase()
    {
        iReportService.insertToDB();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(
                        ResponseConstants.STATUS_200,
                        ResponseConstants.MESSAGE_200
                ));
    }

}
