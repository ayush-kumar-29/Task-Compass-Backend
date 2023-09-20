package workcompass.backend.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {
    @Autowired
    IssueDaoService issueDaoService;

    @GetMapping(value = "/issues")
    public List<Issue> getIssuesList(@RequestParam String assignee, @RequestParam boolean newIssue,
                                     @RequestParam boolean inProgress, @RequestParam boolean resolved){
        return issueDaoService.getIssuesForFilter(assignee, newIssue, inProgress, resolved);
    }

    @GetMapping(value = "/issues/{issueId}")
    public Issue getIssue(@PathVariable int issueId){
        return issueDaoService.getIssueForId(issueId);
    }

    @GetMapping(value = "/issues/countByType")
    public long countTodos(@RequestParam String userName, @RequestParam String status){
        status=status.replace("%20", " ");
        return issueDaoService.countIssues(userName, status);
    }

    @PostMapping(value = "/issues/addIssue")
    public void addIssue(@RequestBody Issue newIssue){
        issueDaoService.addIssue(newIssue, true);
    }

    @DeleteMapping(value = "/issues/deleteIssue/{issueId}")
    public void deleteIssue(@PathVariable int issueId){
        issueDaoService.deleteIssue(issueId);
    }

    @PatchMapping(value="/issues/editIssue/{issueId}")
    public void updateIssue(@RequestParam String updateType, @RequestParam String newStatus,
                            @PathVariable int issueId, @RequestBody Issue issuePatch){
        if(updateType.equalsIgnoreCase("status"))
            issueDaoService.updateIssue(issueId, newStatus);
        else if(updateType.equalsIgnoreCase("content"))
            issueDaoService.updateIssue(issueId, issuePatch);
    }
}
