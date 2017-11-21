package cs5500.project.spring;

import cs5500.project.db.Submission;
import cs5500.project.engine.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Start analyze controller
 */
@RestController
public class AnalyzeController {

    /**
     * Start the analyze process for given assignment id
     * @param id assignment id to process
     * @return a promise of string
     */
    @RequestMapping(value = "/analyze/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DeferredResult<String> analyze(@PathVariable("id") Integer id) {
        DeferredResult<String> defResult = new DeferredResult<>();

        new Thread(() -> {
            Runner.analyze(id);
            String apiResponse = "Analysis complete.";
            defResult.setResult(apiResponse);
        }).start();

        return defResult;
    }
}

