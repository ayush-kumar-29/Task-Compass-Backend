package workcompass.backend.issue;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workcompass.backend.user.UserDaoService;
import workcompass.backend.user.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssueDaoService {
//    private List<Issue> issues;
//    private int issueCount;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private IssueStatus issueStatus;
    @Autowired
    private IssueSeverity issueSeverity;

//    @PostConstruct
//    public void init(){
//        issues = new ArrayList<>();
//        issueCount=4001;
//        issues.add(new Issue(getNewIssueId(), "Issue-1", "Issue-1 Desc-1",
//                LocalDate.now().plusDays(10), "NEW",
//                this.issueStatus.getStatusCode("NEW"), "LOW",
//                issueSeverity.getSeverityCode("LOW"), "user1",
//                userDaoService.getUserIdFromName("user1"), "user2",
//                userDaoService.getUserIdFromName("user2"), LocalDate.now()));
//        issues.add(new Issue(getNewIssueId(), "Issue-11", "Issue-11 Desc-11",
//                LocalDate.now().plusDays(10), "NEW",
//                this.issueStatus.getStatusCode("NEW"), "LOW",
//                issueSeverity.getSeverityCode("LOW"), "user1",
//                userDaoService.getUserIdFromName("user1"), "user2",
//                userDaoService.getUserIdFromName("user2"), LocalDate.now()));
//        issues.add(new Issue(getNewIssueId(), "Issue-2", "Issue-2 Desc-1",
//                LocalDate.now().plusDays(10), "NEW",
//                issueStatus.getStatusCode("NEW"), "LOW",
//                issueSeverity.getSeverityCode("LOW"), "user2",
//                userDaoService.getUserIdFromName("user2"), "user3",
//                userDaoService.getUserIdFromName("user3"), LocalDate.now()));
//        issues.add(new Issue(getNewIssueId(), "Issue-3", "Issue-3 Desc-1",
//                LocalDate.now().plusDays(10), "NEW",
//                issueStatus.getStatusCode("NEW"), "LOW",
//                issueSeverity.getSeverityCode("LOW"), "user3",
//                userDaoService.getUserIdFromName("user3"), "user1",
//                userDaoService.getUserIdFromName("user1"), LocalDate.now()));
//    }

//    private int getNewIssueId(){
//        return issueCount++;
//    }

    public void addIssue(Issue newIssue, boolean isNewIssue){
        if(isNewIssue){
//            newIssue.setIssueId(getNewIssueId());
            newIssue.setStatus("NEW");
            newIssue.setStatusCode(issueStatus.getStatusCode(newIssue.getStatus()));
            newIssue.setSeverityCode(issueSeverity.getSeverityCode(newIssue.getSeverity()));
            newIssue.setAssigneeId(userDaoService.getUserIdFromName(newIssue.getAssigneeName()));
            newIssue.setCreatorId(userDaoService.getUserIdFromName(newIssue.getCreatorName()));
            newIssue.setCreationDate(LocalDate.now());
            newIssue.setIsDeleted(false);
            newIssue.setIssueId(getUniqueTodoId());
        }
//        issues.add(newIssue);
        issueRepository.save(newIssue);
    }

    public List<Issue> getIssuesForFilter(String assignee, boolean newIssue,
                                          boolean inProgress, boolean resolved){
        long assigneeId = userDaoService.getUserIdFromName(assignee);
        List<Issue> issueList = new ArrayList<>();
        if(newIssue){
//            issueList.addAll(issues.stream().filter(
//                    issue -> issue.getAssigneeId()==assigneeId &&
//                            issue.getStatusCode() == IssueStatus.NEW
//            ).toList());
            issueList.addAll(issueRepository.findByAssigneeIdAndStatusCodeAndIsDeleted(assigneeId, IssueStatus.NEW, false));
        }
        if(inProgress){
//            issueList.addAll(issues.stream().filter(
//                    issue -> issue.getAssigneeId()==assigneeId &&
//                            issue.getStatusCode() == IssueStatus.IN_PROGRESS
//            ).toList());
            issueList.addAll(issueRepository.findByAssigneeIdAndStatusCodeAndIsDeleted(assigneeId, IssueStatus.IN_PROGRESS, false));
        }
        if(resolved){
//            issueList.addAll(issues.stream().filter(
//                    issue -> issue.getAssigneeId()==assigneeId &&
//                            issue.getStatusCode() == IssueStatus.RESOLVED
//            ).toList());
            issueList.addAll(issueRepository.findByAssigneeIdAndStatusCodeAndIsDeleted(assigneeId, IssueStatus.RESOLVED, false));
        }
        return issueList;
    }

    public Issue getIssueForId(String issueId){
        return issueRepository.findByIssueId(issueId);
//        return issues.stream().filter(issue -> issue.getIssueId()==issueId).findAny().get();
    }

    public void deleteIssue(String issueId){
//        issues.removeIf(issue -> issue.getIssueId()==issueId);
        Issue issueToDelete = issueRepository.findByIssueId(issueId);
        issueToDelete.setIsDeleted(true);
        issueRepository.save(issueToDelete);
//        issueRepository.deleteByIssueId(issueId);
    }

    public void updateIssue(String issueId, String newStatus){
//        Issue issueToUpdate = issues.stream().filter(issue -> issue.getIssueId()==issueId)
//                .findAny().get();
        Issue issueToUpdate = issueRepository.findByIssueId(issueId);
//        deleteIssue(issueId);
        newStatus = newStatus.replace("%20", " ");
        issueToUpdate.setStatus(newStatus.toUpperCase());
        issueToUpdate.setStatusCode(issueStatus.getStatusCode(newStatus));
        addIssue(issueToUpdate, false);
    }

    public void updateIssue(String issueId, Issue issuePatch){
//        Issue issueToUpdate = issues.stream()
//                .filter(issue -> issue.getIssueId().equals(issueId))
//                .findAny().get();
        Issue issueToUpdate = issueRepository.findByIssueId(issueId);
        issuePatch.setId(issueToUpdate.getId());
        issuePatch.setIssueId(issueToUpdate.getIssueId());
        issuePatch.setStatusCode(issueStatus.getStatusCode(issuePatch.getStatus()));
        issuePatch.setSeverityCode(issueSeverity.getSeverityCode(issuePatch.getSeverity()));
        issuePatch.setAssigneeId(userDaoService.getUserIdFromName(issuePatch.getAssigneeName()));
        issuePatch.setCreatorId(issueToUpdate.getCreatorId());
        issuePatch.setCreatorName(issueToUpdate.getCreatorName());
        issuePatch.setCreationDate(issueToUpdate.getCreationDate());
        issuePatch.setIsDeleted(false);
//        deleteIssue(issueToUpdate.getIssueId());
        addIssue(issuePatch, false);
    }

    public long countIssues(String userName, String status){
        int statusCode = issueStatus.getStatusCode(status);
        long assigneeId = userDaoService.getUserIdFromName(userName);
        return issueRepository.countByAssigneeIdAndStatusCodeAndIsDeleted(assigneeId, statusCode, false);
//        return issues.stream()
//                .filter(
//                        issue -> issue.getAssigneeId()==userDaoService.getUserIdFromName(userName) &&
//                                issue.getStatusCode() == issueStatus.getStatusCode(status)
//                ).count();
    }

    public String getUniqueTodoId(){
        return "I-"+(issueRepository.getRowCount()+1);
    }
}