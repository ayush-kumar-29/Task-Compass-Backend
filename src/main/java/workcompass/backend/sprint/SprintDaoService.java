package workcompass.backend.sprint;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SprintDaoService {
//    private List<Sprint> sprints;
//    private int sprintCount;

    @Autowired
    SprintStatus sprintStatus;

    @Autowired
    private SprintRepository sprintRepository;

//    @PostConstruct
//    public void init() {
//        sprintCount=2001;
//        sprints=new ArrayList<>();
//        sprints.add(new Sprint(getSprintCount(), "Sprint-1",
//                LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(2), "UPCOMING",
//                SprintStatus.UPCOMING));
//        sprints.add(new Sprint(getSprintCount(), "Sprint-2",
//                LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(3), "ONGOING",
//                SprintStatus.ONGOING));
//        sprints.add(new Sprint(getSprintCount(), "Sprint-3",
//                LocalDate.now().plusMonths(4), LocalDate.now().plusMonths(4), "CLOSED",
//                SprintStatus.CLOSED));
//    }

//    private int getSprintCount(){
//        return sprintCount++;
//    }

//    public Sprint getSprintById(String sprintId){
//        return sprintRepository.findBySprintId(sprintId);
//    }

    public List<String> getSprintNames(){
        return sprintRepository.findDistinctSprintName();
//        List<String> sprintNames=new ArrayList<>();
//        for(Sprint sprint:sprints)
//            sprintNames.add(sprint.getSprintName());
//        return sprintNames;
    }

    public void addSprint(Sprint newSprint, boolean isNewSprint){
        if(isNewSprint){
            newSprint.setSprintId(getUniqueSprintId());
            newSprint.setStatus("UPCOMING");
            newSprint.setStatusCode(SprintStatus.UPCOMING);
            newSprint.setIsDeleted(false);
        }
//        sprints.add(newSprint);
        sprintRepository.save(newSprint);
    }

    public List<Sprint> getSprintListForFilter(boolean upcomingFilter, boolean ongoingFilter, boolean closedFilter){
        List<Sprint> sprintList = new ArrayList<>();
        if(upcomingFilter){
//            sprintList.addAll(
//                    sprints.stream()
//                            .filter(sprint -> sprint.getStatusCode() == SprintStatus.UPCOMING).toList()
//            );
            sprintList.addAll(sprintRepository.findByStatusCodeAndIsDeleted(SprintStatus.UPCOMING, false));
        }
        if(ongoingFilter){
//            sprintList.addAll(
//                    sprints.stream()
//                            .filter(sprint -> sprint.getStatusCode() == SprintStatus.ONGOING).toList()
//            );
            sprintList.addAll(sprintRepository.findByStatusCodeAndIsDeleted(SprintStatus.ONGOING, false));
        }
        if(closedFilter){
//            sprintList.addAll(
//                    sprints.stream()
//                            .filter(sprint -> sprint.getStatusCode() == SprintStatus.CLOSED).toList()
//            );
            sprintList.addAll(sprintRepository.findByStatusCodeAndIsDeleted(SprintStatus.CLOSED, false));
        }
        return sprintList;
    }

    public Sprint getSprintForId(String sprintId){
        return sprintRepository.findBySprintId(sprintId);
//        return sprints.stream().filter(sprint -> sprint.getSprintId()==sprintId).findAny().get();
    }

    public void updateSprintStatus(Sprint sprint, String newStatus){
        sprint.setStatus(newStatus);
        sprint.setStatusCode(sprintStatus.getStatusCode(newStatus));
    }
//    public void deleteSprint(int sprintId){
//        sprints.removeIf(sprint -> sprint.getSprintId().equals(sprintId));
//    }

//    public void updateSprintStatus(int sprintId){
//        Sprint sprintToClose=sprints.stream().filter(sprint -> sprint.getSprintId().equals(sprintId))
//                .findAny().get();
//        deleteSprint(sprintId);
//        sprintToClose.setIsSprintClosed(true);
//        addSprint(sprintToClose, false);
//    }

//    public void updateSprintContent(Sprint sprintPatch){
//        // todo: merge update functions?
//        // todo: handle concurrency
//        Sprint sprintToUpdate=sprints.stream()
//                .filter(sprint -> sprint.getSprintId().equals(sprintPatch.getSprintId()))
//                .findAny().get();
//        deleteSprint(sprintPatch.getSprintId());
//        sprintPatch.setSprintId(sprintToUpdate.getSprintId());
//        sprintPatch.setIsSprintClosed(sprintToUpdate.getIsSprintClosed());
//        addSprint(sprintPatch, false);
//    }

    public String getSprintIdFromName(String sprintName){
        return sprintRepository.findSprintIdBySprintName(sprintName);
//        return sprints.stream().filter(sprint -> sprint.getSprintName().equals(sprintName))
//                .findAny().get().getSprintId();
    }

    public boolean sprintNameExists(String sprintName){
        String sprintId = sprintRepository.findSprintIdBySprintName(sprintName);
        return sprintId!=null;
//        boolean exists=false;
//        for(Sprint sprint: sprints){
//            if(sprint.getSprintName().equalsIgnoreCase(sprintName))
//                return true;
//        }
//        return exists;
    }

    public void deleteSprintById(String sprintId) {
        Sprint sprintToDelete = getSprintForId(sprintId);
        sprintToDelete.setIsDeleted(true);
        sprintRepository.save(sprintToDelete);
//        sprintRepository.deleteBySprintId(sprintId);
    }

    public String getUniqueSprintId(){
        return "S-"+(sprintRepository.getRowCount()+1);
    }
}
