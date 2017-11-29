package cs5500.project.web.controllers;

import cs5500.project.engine.Runner;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Start analyze controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AnalyzeController {

    /**
     * Start the analyze process for given assignment id
     * @param id assignment id to process
     * @return a promise of string
     */
    @PostMapping(value = "/assignment/{id}/analyze")
    public DeferredResult<String> analyze(@PathVariable("id") String id) {
        DeferredResult<String> defResult = new DeferredResult<>();

        new Thread(() -> {
            Runner.analyze(id);
            String apiResponse = "Analysis complete.";
            defResult.setResult(apiResponse);
        }).start();

        return defResult;
    }
}

